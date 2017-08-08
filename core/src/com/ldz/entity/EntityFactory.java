package com.ldz.entity;

import com.ldz.component.buyMenu.BuyMenuInputComponent;
import com.ldz.component.buyMenu.BuyMenuInputProcessor;
import com.ldz.component.buyMenuButton.BuyMenuButtonInputComponent;
import com.ldz.component.buyMenuButton.BuyMenuButtonInputProcessor;
import com.ldz.component.buyObjectButton.BuyObjectButtonComponent;
import com.ldz.component.buyObjectButton.BuyObjectInputProcessor;
import com.ldz.component.graphics.GraphicsWithHighLimitCutComponent;
import com.ldz.component.graphics.BasicGraphicsComponent;
import com.ldz.component.score.ScoreGraphicsComponent;
import com.ldz.component.score.ScoreInputComponent;
import com.ldz.component.score.ScoreInputProcessor;
import com.ldz.component.score.ScorePerSecondAccumulatorComponent;
import com.ldz.entity.game.entity.*;
import com.ldz.screen.IScreenSendMessage;

/**
 * Created by Loic on 06/08/2017.
 */
public class EntityFactory {

    public static Entity getEntity(Entity.EntityType entityType, IScreenSendMessage screen) {

        Entity entity = null;

        switch (entityType) {
            case SCORE:
                entity = new ScoreEntity(screen, new ScoreInputComponent(new ScoreInputProcessor()), new ScoreGraphicsComponent(), null,
                        new ScorePerSecondAccumulatorComponent());
                break;
            case BACKGROUND:
                entity = new BackgroundEntity(screen, null, new BasicGraphicsComponent(), null);
                break;
            case BUY_MENU_BUTTON:
                entity = new BuyMenuButtonEntity(screen, new BuyMenuButtonInputComponent(new BuyMenuButtonInputProcessor()), new BasicGraphicsComponent(), null);
                break;
            case BUY_MENU:
                entity = new BuyMenuEntity(screen, new BuyMenuInputComponent(new BuyMenuInputProcessor()), new BasicGraphicsComponent(), null);
                break;
            case BUYABLE_OBJECT_DISPLAY:
                entity = new BuyableObjectDisplayEntity(screen, null, new GraphicsWithHighLimitCutComponent(), null);
                break;
            case BUY_OBJECT_BUTTON:
                entity = new BuyObjectButtonEntity(screen, new BuyObjectButtonComponent(new BuyObjectInputProcessor()), new GraphicsWithHighLimitCutComponent(), null);
                break;
        }

        return entity;

    }

}
