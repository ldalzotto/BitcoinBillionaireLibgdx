package com.ldz.entity;

import com.ldz.background.components.BackgroundGraphicsComponent;
import com.ldz.entity.component.abs.InputComponent;
import com.ldz.entity.component.abs.PhysicsComponent;

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

    public BackgroundEntity(InputComponent inputComponent, BackgroundGraphicsComponent graphicsComponent, PhysicsComponent physicsComponent) {
        super(null, graphicsComponent, null);
    }
}
