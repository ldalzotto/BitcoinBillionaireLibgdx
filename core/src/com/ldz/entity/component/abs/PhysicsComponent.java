package com.ldz.entity.component.abs;

import com.ldz.entity.Entity;
import com.ldz.entity.component.Component;

/**
 * Created by Loic on 06/08/2017.
 */
public abstract class PhysicsComponent implements Component {

    protected Entity entityReference;

    public abstract void update(float delta);

    @Override
    public void setEntityReference(Entity entityReference) {
        this.entityReference = entityReference;
    }

}
