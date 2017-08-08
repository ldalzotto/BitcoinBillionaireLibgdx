package com.ldz.entity.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.ldz.component.graphics.GraphicsWithHighLimitCutComponent;
import com.ldz.entity.Entity;
import com.ldz.entity.component.abs.BehaviorComponent;
import com.ldz.entity.component.abs.GraphicsComponent;
import com.ldz.entity.component.abs.InputComponent;
import com.ldz.entity.component.abs.PhysicsComponent;
import com.ldz.screen.IScreenSendMessage;

/**
 * Created by Loic on 08/08/2017.
 */
public class BuyObjectButtonEntity extends Entity {

    public BuyObjectButtonEntity(IScreenSendMessage screen, InputComponent inputComponent, GraphicsComponent graphicsComponent, PhysicsComponent physicsComponent, BehaviorComponent... behaviorComponents) {
        super(screen, inputComponent, graphicsComponent, physicsComponent, behaviorComponents);
        ((GraphicsWithHighLimitCutComponent) this.getGraphicsComponent()).setTexture(new Texture(Gdx.files.internal("menu/buy_object_button.png")));
    }

    public void initializeEntityFromPosition(Vector2 position){
        this.setPosition(position);
        this.setBoundingRectangle(new Rectangle(position.x, position.y, 10, 10));
    }


}
