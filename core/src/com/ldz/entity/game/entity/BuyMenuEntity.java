package com.ldz.entity.game.entity;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.ldz.entity.Entity;
import com.ldz.entity.component.abs.BehaviorComponent;
import com.ldz.entity.component.abs.GraphicsComponent;
import com.ldz.entity.component.abs.InputComponent;
import com.ldz.entity.component.abs.PhysicsComponent;
import com.ldz.screen.IScreenSendMessage;

/**
 * Created by Loic on 07/08/2017.
 */
public class BuyMenuEntity extends Entity {

    public BuyMenuEntity(IScreenSendMessage screen, InputComponent inputComponent, GraphicsComponent graphicsComponent, PhysicsComponent physicsComponent, BehaviorComponent... behaviorComponents) {
        super(screen, inputComponent, graphicsComponent, physicsComponent, behaviorComponents);
        setPosition(new Vector2(50,50));
        setBoundingRectangle(new Rectangle(getPosition().x, getPosition().y, 20,20));
        graphicsComponent.setEntityReference(this);
        inputComponent.setEntityReference(this);
    }
}
