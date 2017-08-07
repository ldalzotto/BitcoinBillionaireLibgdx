package com.ldz.component.background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.ldz.entity.component.abs.GraphicsComponent;
import com.ldz.entity.game.entity.BackgroundEntity;
import com.ldz.entity.message.Message;

/**
 * Created by Loic on 06/08/2017.
 * The graphic component of {@link com.ldz.entity.Entity.EntityType#BACKGROUND}.
 * Just displaying background.
 */
public class BackgroundGraphicsComponent extends GraphicsComponent {

    private Texture backgroundTexture;

    public BackgroundGraphicsComponent(){
        backgroundTexture = new Texture(Gdx.files.classpath("background/brick.png"));
    }

    @Override
    public void receiveMessage(Message message) {

    }

    @Override
    public void update(SpriteBatch spriteBatch, float delta, OrthographicCamera orthographicCamera) {
        BackgroundEntity backgroundEntity = (BackgroundEntity) entityReference;
        Vector3 vector3 = orthographicCamera.project(new Vector3(backgroundEntity.getPosition().x, backgroundEntity.getPosition().y, 0));
        spriteBatch.draw(backgroundTexture, vector3.x, vector3.y);
    }

}
