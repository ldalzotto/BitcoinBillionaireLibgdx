package com.ldz.entity.component.abs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.ldz.entity.Entity;
import com.ldz.entity.component.Component;

/**
 * Created by Loic on 06/08/2017.
 */
public abstract class InputComponent implements Component{

    protected InputProcessor inputProcessor;
    protected Entity entityReference;

    public InputComponent(InputProcessor inputProcessor) {
        this.inputProcessor = inputProcessor;
        Gdx.input.setInputProcessor(inputProcessor);
    }

    public abstract void update(float delta);

    @Override
    public void setEntityReference(Entity entityReference) {
        this.entityReference = entityReference;
    }
}
