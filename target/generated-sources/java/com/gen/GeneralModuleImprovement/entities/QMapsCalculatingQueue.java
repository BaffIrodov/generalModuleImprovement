package com.gen.GeneralModuleImprovement.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMapsCalculatingQueue is a Querydsl query type for MapsCalculatingQueue
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMapsCalculatingQueue extends EntityPathBase<MapsImprovementQueue> {

    private static final long serialVersionUID = 1921423345L;

    public static final QMapsCalculatingQueue mapsCalculatingQueue = new QMapsCalculatingQueue("mapsCalculatingQueue");

    public final NumberPath<Integer> calculationTime = createNumber("calculationTime", Integer.class);

    public final NumberPath<Integer> idStatsMap = createNumber("idStatsMap", Integer.class);

    public final BooleanPath processed = createBoolean("processed");

    public QMapsCalculatingQueue(String variable) {
        super(MapsImprovementQueue.class, forVariable(variable));
    }

    public QMapsCalculatingQueue(Path<? extends MapsImprovementQueue> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMapsCalculatingQueue(PathMetadata metadata) {
        super(MapsImprovementQueue.class, metadata);
    }

}

