package com.gen.GeneralModuleImprovement.services;

import com.gen.GeneralModuleImprovement.calculatingMethods.*;
import com.gen.GeneralModuleImprovement.common.MapsEnum;
import com.gen.GeneralModuleImprovement.dtos.ImprovementRequestDto;
import com.gen.GeneralModuleImprovement.dtos.MapsCalculatingQueueResponseDto;
import com.gen.GeneralModuleImprovement.entities.*;
import com.gen.GeneralModuleImprovement.entities.PlayerForce;
import com.gen.GeneralModuleImprovement.readers.ImprovementReader;
import com.gen.GeneralModuleImprovement.repositories.MapsImprovementQueueRepository;
import com.gen.GeneralModuleImprovement.repositories.PlayerForceRepository;
import com.gen.GeneralModuleImprovement.entities.MapsImprovementQueue;
import com.gen.GeneralModuleImprovement.entities.PlayerOnMapResults;
import com.gen.GeneralModuleImprovement.entities.RoundHistory;
import com.querydsl.core.group.GroupBy;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ImprovementService {

    @Autowired
    MapsImprovementQueueRepository mapsImprovementQueueRepository;

    @Autowired
    PlayerForceRepository playerForceRepository;

    @Autowired
    AdrCalculator adrCalculator;

    @Autowired
    KillsCalculator killsCalculator;

    @Autowired
    HeadshotsCalculator headshotsCalculator;

    @Autowired
    Rating20Calculator rating20Calculator;

    @Autowired
    RoundHistoryCalculator roundHistoryCalculator;

    @Autowired
    Calculator calculator;

    @Autowired
    StabilityCalculator stabilityCalculator;

    @Autowired
    ImprovementReader improvementReader;

    @Autowired
    JPAQueryFactory queryFactory;

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> getConfig() {
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081" + "/improvement/get-config")
                .build(false)
                .toUriString();
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>("test", headers);

            ResponseEntity<Map<String, Object>> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<Map<String, Object>>() {
                    });

            Map<String, Object> result = responseEntity.getBody();
            if (result == null)
                System.out.println("Null");
            return result;
        } catch (Exception e) {
            System.out.println("impossible");
        }
        return null;
    }

    public List<Long> noConfig(ImprovementRequestDto request) {
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081" + "/improvement/no-config")
                .build(false)
                .toUriString();
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(request, headers);

            ResponseEntity<List<Long>> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    new ParameterizedTypeReference<List<Long>>() {
                    });

            List<Long> result = responseEntity.getBody();
            if (result == null)
                System.out.println("Null");
            return result;
        } catch (Exception e) {
            System.out.println("impossible");
        }
        return new ArrayList<>();
    }

    public List<Long> withConfig(ImprovementRequestDto request) {
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081" + "/improvement/with-config")
                .build(false)
                .toUriString();
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(request, headers);

            ResponseEntity<List<Long>> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    new ParameterizedTypeReference<List<Long>>() {
                    });

            List<Long> result = responseEntity.getBody();
            if (result == null)
                System.out.println("Null");
            return result;
        } catch (Exception e) {
            System.out.println("impossible");
        }
        return new ArrayList<>();
    }
}
