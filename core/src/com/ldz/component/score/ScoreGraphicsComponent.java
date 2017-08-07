package com.ldz.component.score;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.ldz.entity.component.abs.GraphicsComponent;
import com.ldz.entity.game.entity.ScoreEntity;
import com.ldz.entity.message.Message;

/**
 * Created by Loic on 06/08/2017.
 */
public class ScoreGraphicsComponent extends GraphicsComponent {

    private BitmapFont bitmapFont = new BitmapFont();

    @Override
    public void receiveMessage(Message message) {

    }

    @Override
    public void update(SpriteBatch spriteBatch, float delta, OrthographicCamera orthographicCamera) {
        ScoreEntity scoreEntity = (ScoreEntity) entityReference;
        Vector3 vector3 = orthographicCamera.project(new Vector3(scoreEntity.getPosition().x, scoreEntity.getPosition().y, 0));
        bitmapFont.draw(spriteBatch, scoreEntity.getCurrentScore().toString(), vector3.x, vector3.y);
    }

}
