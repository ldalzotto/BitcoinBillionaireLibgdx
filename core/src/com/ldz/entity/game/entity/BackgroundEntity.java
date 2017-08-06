package com.ldz.entity.game.entity;

import com.badlogic.gdx.math.Vector2;
import com.ldz.component.background.BackgroundGraphicsComponent;
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
class Entity {
    + position
}
class BackgroundGraphicsComponent {
    + backgroundTexture
}
Entity -down-> BackgroundGraphicsComponent
@enduml
 */
public class BackgroundEntity extends Entity {

    public BackgroundEntity(IScreenSendMessage iScreenSendMessage, InputComponent inputComponent, BackgroundGraphicsComponent graphicsComponent, PhysicsComponent physicsComponent) {
        super(iScreenSendMessage, null, graphicsComponent, null);
        setPosition(new Vector2(0,0));
        graphicsComponent.setEntityReference(this);
    }
}
