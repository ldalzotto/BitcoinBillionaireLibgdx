package com.ldz.entity.component.abs;

import com.ldz.entity.Entity;
import com.ldz.entity.component.Component;

/**
 * Created by Loic on 06/08/2017.
 */
public abstract class InputComponent implements Component{

    public abstract void update(Entity entity, float delta);

}
