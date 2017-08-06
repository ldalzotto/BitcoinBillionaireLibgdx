package com.ldz.entity.component.abs;

import com.ldz.entity.Entity;
import com.ldz.entity.component.Component;

/**
 * Created by Loic on 07/08/2017.
 */
public abstract class BehaviorComponent implements Component {

    protected Entity entityReference;

    @Override
    public void setEntityReference(Entity entityReference) {
        this.entityReference = entityReference;
    }

    public abstract void update(float delta);

}
