package com.ldz.component.score;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ldz.entity.component.abs.GraphicsComponent;
import com.ldz.entity.game.entity.ScoreEntity;

/**
 * Created by Loic on 06/08/2017.
 */
public class ScoreGraphicsComponent extends GraphicsComponent {

    private BitmapFont bitmapFont = new BitmapFont();

    @Override
    public void receiveMessage(String message) {

    }

    @Override
    public void update(SpriteBatch spriteBatch, float delta) {
        ScoreEntity scoreEntity = (ScoreEntity) entityReference;
        bitmapFont.draw(spriteBatch, scoreEntity.getCurrentScore().toString(), scoreEntity.getPosition().x, scoreEntity.getPosition().y);
    }

}
