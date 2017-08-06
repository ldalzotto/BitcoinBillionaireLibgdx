package com.ldz.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ldz.entity.component.Component;
import com.ldz.entity.component.abs.GraphicsComponent;
import com.ldz.entity.component.abs.InputComponent;
import com.ldz.entity.component.abs.PhysicsComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Loic on 06/08/2017.
 */
public class Entity {

    public enum EntityType{
        SCORE, BACKGROUND;
    }

    private InputComponent inputComponent;
    private GraphicsComponent graphicsComponent;
    private PhysicsComponent physicsComponent;

    private List<Component> componentList;

    protected Boolean isDetroyable = false;

    public Entity(InputComponent inputComponent, GraphicsComponent graphicsComponent, PhysicsComponent physicsComponent){
        this.inputComponent = inputComponent;
        this.graphicsComponent = graphicsComponent;
        this.physicsComponent = physicsComponent;

        componentList = new ArrayList<>();

        if(this.inputComponent != null){
            componentList.add(this.inputComponent);
        }

        if(this.physicsComponent != null){
            componentList.add(this.physicsComponent);
        }

        if(this.graphicsComponent != null){
            componentList.add(this.graphicsComponent);
        }


    }

    public void update(float delta, SpriteBatch spriteBatch){
        if(this.inputComponent != null){
            inputComponent.update(this, delta);
        }

        if(this.physicsComponent != null){
            physicsComponent.update(this, delta);
        }

        if(this.graphicsComponent != null){
            graphicsComponent.update(this, spriteBatch, delta);
        }
    }

    public void sendMessage(Component.MESSAGE messageType, String... args){

        StringBuilder fullMessage = new StringBuilder();
        fullMessage.append(messageType.toString());

        for(String string :
                args){
            fullMessage.append(Component.MESSAGE_TOKEN);
            fullMessage.append(string);
        }

        for (Component component :
                componentList) {
            component.receiveMessage(fullMessage.toString());
        }
    }

    public void setIsDetroyable(){
        isDetroyable = true;
    }

    public Boolean getIsDetroyable(){
        return isDetroyable;
    }

}
