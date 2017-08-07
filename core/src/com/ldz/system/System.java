package com.ldz.system;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ldz.entity.Entity;
import com.ldz.entity.message.Message;
import com.ldz.screen.IScreenSendMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Loic on 07/08/2017.
 */
public abstract class System implements IScreenSendMessage {

    protected List<Entity> entities = new ArrayList<>();

    public void update(float delta, SpriteBatch spriteBatch, OrthographicCamera orthographicCamera){
        entities.forEach(entity -> entity.update(delta, spriteBatch, orthographicCamera));
    }

    public List<Entity> getEntities() {
        return entities;
    }

    @Override
    public void sendMessageToAllEntities(Message message) {
        entities.forEach(entity -> entity.sendMessage(message));
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }
}
