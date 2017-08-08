package com.ldz.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.ldz.component.background.BackgroundGraphicsComponent;
import com.ldz.component.buyMenu.BuyMenuGraphicsComponent;
import com.ldz.component.buyMenu.BuyMenuInputComponent;
import com.ldz.component.buyMenu.BuyMenuInputProcessor;
import com.ldz.component.buyMenuButton.BuyMenuButtonGraphicsComponent;
import com.ldz.component.buyMenuButton.BuyMenuButtonInputComponent;
import com.ldz.component.buyMenuButton.BuyMenuButtonInputProcessor;
import com.ldz.component.graphics.BasicGraphicsComponent;
import com.ldz.component.score.ScoreGraphicsComponent;
import com.ldz.component.score.ScoreInputComponent;
import com.ldz.component.score.ScoreInputProcessor;
import com.ldz.component.score.ScorePerSecondAccumulatorComponent;
import com.ldz.entity.game.entity.BackgroundEntity;
import com.ldz.entity.game.entity.BuyMenuButtonEntity;
import com.ldz.entity.game.entity.BuyMenuEntity;
import com.ldz.entity.game.entity.ScoreEntity;
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
                entity = new BackgroundEntity(screen, null, new BasicGraphicsComponent(Gdx.files.classpath("background/brick.png")), null);
                break;
            case BUY_MENU_BUTTON:
                entity = new BuyMenuButtonEntity(screen, new BuyMenuButtonInputComponent(new BuyMenuButtonInputProcessor()), new BasicGraphicsComponent(Gdx.files.internal("menu/buy_button.png")), null);
                break;
            case BUY_MENU:
                entity = new BuyMenuEntity(screen, new BuyMenuInputComponent(new BuyMenuInputProcessor()), new BasicGraphicsComponent(Gdx.files.internal("menu/buy_menu.png")), null);
                break;
        }

        return entity;

    }

}
