package com.ldz.entity.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.ldz.component.graphics.BasicGraphicsComponent;
import com.ldz.entity.Entity;
import com.ldz.entity.component.abs.InputComponent;
import com.ldz.entity.component.abs.PhysicsComponent;
import com.ldz.screen.IScreenSendMessage;

/**
 * Created by Loic on 06/08/2017.
 * <p>
 * The main background entity.
 * This entity is just a static component displaying background image.
 * <p>
 * <img src="doc-files/background-entity.png" alt="BitcoineBillionaire main">
 */
/* @startuml doc-files/background-entity.png
    class BackgroundEntity {
        + position
        + boundingRectangle
    }
    class BasicGraphicsComponent {
        + texture
    }
    BackgroundEntity -down-> BasicGraphicsComponent
@enduml
 */
public class BackgroundEntity extends Entity {

    public BackgroundEntity(IScreenSendMessage iScreenSendMessage, InputComponent inputComponent, BasicGraphicsComponent graphicsComponent, PhysicsComponent physicsComponent) {
        super(iScreenSendMessage, null, graphicsComponent, null);
        ((BasicGraphicsComponent)this.getGraphicsComponent()).setTexture(new Texture(Gdx.files.classpath("background/brick.png")));
        setPosition(new Vector2(50, 50));
    }
}
