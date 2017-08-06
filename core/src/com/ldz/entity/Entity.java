package com.ldz.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.ldz.entity.component.Component;
import com.ldz.entity.component.abs.BehaviorComponent;
import com.ldz.entity.component.abs.GraphicsComponent;
import com.ldz.entity.component.abs.InputComponent;
import com.ldz.entity.component.abs.PhysicsComponent;
import com.ldz.screen.IScreenSendMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Loic on 06/08/2017.
 */
public class Entity {

    private static String TAG;

    public enum EntityType{
        SCORE, BACKGROUND;
    }

    private IScreenSendMessage screenReference;

    private InputComponent inputComponent;
    private GraphicsComponent graphicsComponent;
    private PhysicsComponent physicsComponent;
    private List<BehaviorComponent> behaviorComponents;

    private List<Component> componentList;

    private Vector2 position = new Vector2();

    protected Boolean isDetroyable = false;

    public Entity(IScreenSendMessage screen, InputComponent inputComponent, GraphicsComponent graphicsComponent, PhysicsComponent physicsComponent,
                  BehaviorComponent... behaviorComponents){
        TAG = getClass().getSimpleName();

        this.screenReference = screen;

        this.inputComponent = inputComponent;
        this.graphicsComponent = graphicsComponent;
        this.physicsComponent = physicsComponent;
        this.behaviorComponents = Arrays.asList(behaviorComponents);

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

        if(this.behaviorComponents != null){
            componentList.addAll(this.behaviorComponents);
        }


    }

    public void update(float delta, SpriteBatch spriteBatch){
        if(this.inputComponent != null){
            inputComponent.update(delta);
        }

        if(this.physicsComponent != null){
            physicsComponent.update(delta);
        }

        if(this.graphicsComponent != null){
            graphicsComponent.update(spriteBatch, delta);
        }

        if(this.behaviorComponents != null){
            behaviorComponents.forEach(behaviorComponent -> behaviorComponent.update(delta));
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

        Gdx.app.debug(TAG, "Sending message : " + fullMessage);

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

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getPosition() {
        return position;
    }

    public IScreenSendMessage getScreenReference() {
        return screenReference;
    }
}
