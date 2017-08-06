package com.ldz.entity;

import com.ldz.component.background.BackgroundGraphicsComponent;
import com.ldz.component.score.ScoreGraphicsComponent;
import com.ldz.component.score.ScoreInputComponent;
import com.ldz.component.score.ScoreInputProcessor;
import com.ldz.component.score.ScorePerSecondAccumulatorComponent;
import com.ldz.entity.game.entity.BackgroundEntity;
import com.ldz.entity.game.entity.ScoreEntity;
import com.ldz.screen.IScreenSendMessage;

/**
 * Created by Loic on 06/08/2017.
 */
public class EntityFactory {

    public static Entity getEntity(Entity.EntityType entityType, IScreenSendMessage screen){

        Entity entity = null;

        switch (entityType){
            case SCORE:
                entity = new ScoreEntity(screen, new ScoreInputComponent(new ScoreInputProcessor()), new ScoreGraphicsComponent(), null,
                        new ScorePerSecondAccumulatorComponent());
                break;
            case BACKGROUND:
                entity = new BackgroundEntity(screen, null, new BackgroundGraphicsComponent(), null);
                break;
        }

        return entity;

    }

}
