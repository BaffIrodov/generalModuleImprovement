package com.gen.GeneralModuleImprovement.services;

import com.gen.GeneralModuleImprovement.entities.PlayerForce;
import com.gen.GeneralModuleImprovement.entities.QPlayerForce;
import com.gen.GeneralModuleImprovement.entities.QPlayerOnMapResults;
import com.gen.GeneralModuleImprovement.repositories.PlayerForceRepository;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.util.*;

import static java.lang.Math.abs;

@Service
public class DebugService {

    @Autowired
    JPAQueryFactory queryFactory;

    @Autowired
    PlayerForceRepository playerForceRepository;


    private static final QPlayerOnMapResults playerOnMapResults =
            new QPlayerOnMapResults("playerOnMapResults");

    private static final QPlayerForce playerForce =
            new QPlayerForce("playerForce");

    public void resetAllPlayerForcesToDefault() {
        System.out.println("Сброс всех сил плэйеров начался");
        long now = System.currentTimeMillis();
        List<PlayerForce> forces = playerForceRepository.findAll();
        List<PlayerForce> newList = new ArrayList<>();
        forces.forEach(f -> {
            if(f.playerForce != 5f || f.playerStability != 100) {
                newList.add(new PlayerForce(f.id, f.playerId, 5f, 100, f.map));
            }
        });
        playerForceRepository.saveAll(newList);
        System.out.println("Сброс всех сил плэйеров занял: " + (System.currentTimeMillis() - now) + " мс");
    }

    public void getFilesWithDistribution() {
        getFullListFloat(playerOnMapResults.adr, "D:/test/select_adr.txt");
        getFullListFloat(playerOnMapResults.cast20, "D:/test/select_cast20.txt");
        getFullListFloat(playerOnMapResults.rating20, "D:/test/select_rating20.txt");
        getFullListInteger(playerOnMapResults.kills, "D:/test/select_kills.txt");
        getFullListInteger(playerOnMapResults.headshots, "D:/test/select_headshots.txt");
    }

    public void getFullListFloat(NumberPath<Float> path, String fileName) {
        try {
            FileWriter file = new FileWriter(fileName);
            List<Float> result = queryFactory.from(playerOnMapResults).select(path).fetch();
            Map<Float, Integer> resultWithFreq = getResultsWithFrequenciesFloat(result);
            for (Map.Entry<Float, Integer> pair : resultWithFreq.entrySet()) {
                file.write(pair.getKey().toString().replace(".", ",") + "\t" + pair.getValue() + "\n");
            }
            file.flush();
        } catch (Exception e) {
            //nothing
        }
    }

    public void getFullListInteger(NumberPath<Integer> path, String fileName) {
        try {
            FileWriter file = new FileWriter(fileName);
            List<Integer> result = queryFactory.from(playerOnMapResults).select(path).fetch();
            Map<Integer, Integer> resultWithFreq = getResultsWithFrequenciesInteger(result);
            for (Map.Entry<Integer, Integer> pair : resultWithFreq.entrySet()) {
                file.write(pair.getKey() + "\t" + pair.getValue() + "\n");
            }
            file.flush();
        } catch (Exception e) {
            //nothing
        }
    }

    private List<Float> getSliceByPercent(int minPercent, int maxPercent, List<Float> source) {
        Collections.sort(source);
        List<Float> result = new ArrayList<>();
        int minIndex = (source.size() / 100) * minPercent;
        int maxIndex = (source.size() / 100) * maxPercent;
        int index = 0;
        for (Float item : source) {
            if (minIndex <= index && index <= maxIndex) {
                result.add(item);
            }
            index++;
        }
        return result;
    }

    //просто для красивого графика делаем подлог в данных
    private List<Float> getGroupForGauss(int parts, List<Float> source) {
        Collections.sort(source);
        int indexOfPart = source.size() / parts;
        for (int i = 0; i < parts; i++) {
            int minIndex = indexOfPart * i;
            int maxIndex = indexOfPart * (i + 1);
            float average = (source.get(minIndex) + source.get(maxIndex)) / 2;
            for (int index = minIndex; index < maxIndex; index++) {
                source.set(index, average);
            }
        }
        return source;
    }

    private float getAverageOfListFloat(List<Float> source) {
        return (float) source.stream().mapToDouble(e -> e).average().orElse(0);
    }

    private int getAverageOfListInt(List<Integer> source) {
        return (int) source.stream().mapToInt(e -> e).average().orElse(0);
    }

    private Map<Integer, Integer> getResultsWithFrequenciesInteger(List<Integer> results) {
        Map<Integer, Integer> resultsWithFrequencies = new TreeMap<>();
        Set<Integer> resultNoRepeat = new HashSet<>(results);
        resultNoRepeat.forEach(el -> {
            resultsWithFrequencies.put(el,
                    results.stream().filter(res -> res == el).toList().size());
        });
        return resultsWithFrequencies;
    }

    private Map<Float, Integer> getResultsWithFrequenciesFloat(List<Float> results) {
        Map<Float, Integer> resultsWithFrequencies = new TreeMap<>();
        Set<Float> resultNoRepeat = new HashSet<>(results);
        resultNoRepeat.forEach(el -> {
            resultsWithFrequencies.put(el,
                    results.stream().filter(res -> abs(res - el) < 0.00001).toList().size());
        });
        return resultsWithFrequencies;
    }
}
