package com.ldz.entity.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.ldz.component.graphics.GraphicsWithHighLimitCutComponent;
import com.ldz.entity.Entity;
import com.ldz.entity.component.abs.BehaviorComponent;
import com.ldz.entity.component.abs.InputComponent;
import com.ldz.entity.component.abs.PhysicsComponent;
import com.ldz.screen.IScreenSendMessage;

/**
 * Created by Loic on 08/08/2017.
 */
public class BuyableObjectDisplayEntity extends Entity {

    public static int DISPLAY_WIDTH = 50;
    public static int DISPLAY_HEIGHT = 30;

    private Integer currentLevel;
    private Integer costToNextLevel;
    private Integer costBonusPerSecond;

    public BuyableObjectDisplayEntity(IScreenSendMessage screen, InputComponent inputComponent, GraphicsWithHighLimitCutComponent graphicsComponent, PhysicsComponent physicsComponent, BehaviorComponent... behaviorComponents) {
        super(screen, inputComponent, graphicsComponent, physicsComponent, behaviorComponents);
        ((GraphicsWithHighLimitCutComponent) this.getGraphicsComponent()).setTexture(new Texture(Gdx.files.internal("menu/buyable_object_display.png")));
        this.costBonusPerSecond = 4;
    }

    public void initializeEntityFromPosition(Vector2 position) {
        this.setPosition(position);
        this.setBoundingRectangle(new Rectangle(position.x, position.y, DISPLAY_WIDTH, DISPLAY_HEIGHT));
    }

    public Integer getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Integer currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Integer getCostToNextLevel() {
        return costToNextLevel;
    }

    public void setCostToNextLevel(Integer costToNextLevel) {
        this.costToNextLevel = costToNextLevel;
    }

    public Integer getCostBonusPerSecond() {
        return costBonusPerSecond;
    }

    public void setCostBonusPerSecond(Integer costBonusPerSecond) {
        this.costBonusPerSecond = costBonusPerSecond;
    }
}
