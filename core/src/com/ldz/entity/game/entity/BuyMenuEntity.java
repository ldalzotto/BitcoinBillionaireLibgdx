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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Loic on 07/08/2017.
 */
public class BuyMenuEntity extends Entity {

    private List<Vector2> buyableObjectsSlots = new ArrayList<>();

    public BuyMenuEntity(IScreenSendMessage screen, InputComponent inputComponent, BasicGraphicsComponent graphicsComponent, PhysicsComponent physicsComponent, BehaviorComponent... behaviorComponents) {
        super(screen, inputComponent, graphicsComponent, physicsComponent, behaviorComponents);
        setPosition(new Vector2(150, 100));
        setBoundingRectangle(new Rectangle(getPosition().x, getPosition().y, 40,90));
        ((BasicGraphicsComponent)this.getGraphicsComponent()).setTexture(new Texture(Gdx.files.internal("menu/buy_menu.png")));

        //init slots
        Vector2 currentPosition = this.getPosition();
        for(int i =0; i< 3; i++){
            Vector2 vector2slot = new Vector2(currentPosition.x, currentPosition.y + i*BuyableObjectDisplayEntity.DISPLAY_HEIGHT);
            buyableObjectsSlots.add(vector2slot);
        }

    }

    public List<Vector2> getBuyableObjectsSlots() {
        return buyableObjectsSlots;
    }

    public float getHighestPointOrdinate(){
        return (this.getBoundingRectangle().y + this.getBoundingRectangle().height);
    }
}
