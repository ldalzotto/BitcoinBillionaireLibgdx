package com.ldz.component.background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ldz.entity.component.abs.GraphicsComponent;
import com.ldz.entity.game.entity.BackgroundEntity;

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
    public void receiveMessage(String message) {

    }

    @Override
    public void update(SpriteBatch spriteBatch, float delta) {
        BackgroundEntity backgroundEntity = (BackgroundEntity) entityReference;
        spriteBatch.draw(backgroundTexture, backgroundEntity.getPosition().x, backgroundEntity.getPosition().y);
    }

}
