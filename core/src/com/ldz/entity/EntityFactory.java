package com.ldz.entity;

import com.ldz.background.components.BackgroundGraphicsComponent;

/**
 * Created by Loic on 06/08/2017.
 */
public class EntityFactory {

    public static Entity getEntity(Entity.EntityType entityType){

        Entity entity = null;

        switch (entityType){
            case SCORE:
                entity = new Entity(null, null, null);
            case BACKGROUND:
                entity = new Entity(null, new BackgroundGraphicsComponent(), null);
        }

        return entity;

    }

}
