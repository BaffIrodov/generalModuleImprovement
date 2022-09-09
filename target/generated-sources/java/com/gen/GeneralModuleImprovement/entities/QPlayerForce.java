package com.gen.GeneralModuleImprovement.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPlayerForce is a Querydsl query type for PlayerForce
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlayerForce extends EntityPathBase<PlayerForce> {

    private static final long serialVersionUID = 1362781182L;

    public static final QPlayerForce playerForce1 = new QPlayerForce("playerForce1");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath map = createString("map");

    public final NumberPath<Float> playerForce = createNumber("playerForce", Float.class);

    public final NumberPath<Integer> playerId = createNumber("playerId", Integer.class);

    public final NumberPath<Integer> playerStability = createNumber("playerStability", Integer.class);

    public QPlayerForce(String variable) {
        super(PlayerForce.class, forVariable(variable));
    }

    public QPlayerForce(Path<? extends PlayerForce> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPlayerForce(PathMetadata metadata) {
        super(PlayerForce.class, metadata);
    }

}

