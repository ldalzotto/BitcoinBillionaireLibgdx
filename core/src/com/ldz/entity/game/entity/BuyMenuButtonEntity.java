package com.ldz.entity.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.ldz.component.graphics.BasicGraphicsComponent;
import com.ldz.entity.Entity;
import com.ldz.entity.component.abs.BehaviorComponent;
import com.ldz.entity.component.abs.InputComponent;
import com.ldz.entity.component.abs.PhysicsComponent;
import com.ldz.screen.IScreenSendMessage;

/**
 * Created by Loic on 07/08/2017.
 */
public class BuyMenuButtonEntity extends Entity {

    public BuyMenuButtonEntity(IScreenSendMessage screen, InputComponent inputComponent, BasicGraphicsComponent graphicsComponent, PhysicsComponent physicsComponent, BehaviorComponent... behaviorComponents) {
        super(screen, inputComponent, graphicsComponent, physicsComponent, behaviorComponents);
        setPosition(new Vector2(0, 0));
        setBoundingRectangle(new Rectangle(getPosition().x, getPosition().y, 20, 20));
        ((BasicGraphicsComponent) this.getGraphicsComponent()).setTexture(new Texture(Gdx.files.internal("menu/buy_button.png")));
    }
}
