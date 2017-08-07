package com.ldz.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.ldz.entity.component.Component;
import com.ldz.entity.component.abs.BehaviorComponent;
import com.ldz.entity.component.abs.GraphicsComponent;
import com.ldz.entity.component.abs.InputComponent;
import com.ldz.entity.component.abs.PhysicsComponent;
import com.ldz.entity.message.Message;
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
        SCORE, BACKGROUND, BUY_MENU;
    }

    private IScreenSendMessage screenReference;

    private InputComponent inputComponent;
    private GraphicsComponent graphicsComponent;
    private PhysicsComponent physicsComponent;
    private List<BehaviorComponent> behaviorComponents;

    private List<Component> componentList;

    private Vector2 position = new Vector2();
    private Rectangle boundingRectangle = new Rectangle();


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

    public void update(float delta, SpriteBatch spriteBatch, OrthographicCamera orthographicCamera){
        if(this.inputComponent != null){
            inputComponent.update(delta, orthographicCamera);
        }

        if(this.physicsComponent != null){
            physicsComponent.update(delta);
        }

        if(this.graphicsComponent != null){
            graphicsComponent.update(spriteBatch, delta, orthographicCamera);
        }

        if(this.behaviorComponents != null){
            behaviorComponents.forEach(behaviorComponent -> behaviorComponent.update(delta));
        }

    }

    public void sendMessage(Message message){


        Gdx.app.debug(TAG, "Sending message : " + message.toString());

        for (Component component :
                componentList) {
            component.receiveMessage(message);
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

    public Rectangle getBoundingRectangle() {
        return boundingRectangle;
    }

    public void setBoundingRectangle(Rectangle boundingRectangle) {
        this.boundingRectangle = boundingRectangle;
    }

    public IScreenSendMessage getScreenReference() {
        return screenReference;
    }
}
