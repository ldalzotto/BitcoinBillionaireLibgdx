package com.ldz.entity.component.abs;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.ldz.entity.Entity;
import com.ldz.entity.component.Component;
import com.ldz.input.MyInputMultiplexer;

/**
 * Created by Loic on 06/08/2017.
 */
public abstract class InputComponent implements Component{

    protected InputProcessor inputProcessor;
    protected Entity entityReference;

    public InputComponent(InputProcessor inputProcessor) {
        this.inputProcessor = inputProcessor;
        MyInputMultiplexer.getInstance().addProcessor(inputProcessor);
    }

    public abstract void update(float delta, OrthographicCamera orthographicCamera);

    @Override
    public void setEntityReference(Entity entityReference) {
        this.entityReference = entityReference;
    }

    public Entity getEntityReference() {
        return entityReference;
    }
}
