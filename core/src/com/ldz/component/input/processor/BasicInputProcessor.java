package com.ldz.component.input.processor;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.ldz.entity.component.abs.InputComponent;

/**
 * Created by Loic on 08/08/2017.
 */
public abstract class BasicInputProcessor implements InputProcessor {

    protected InputComponent inputComponentReference;
    protected OrthographicCamera orthographicCamera;

    public InputComponent getInputComponentReference() {
        return inputComponentReference;
    }

    public void setInputComponentReference(InputComponent inputComponentReference) {
        this.inputComponentReference = inputComponentReference;
    }

    public void setOrthographicCamera(OrthographicCamera orthographicCamera) {
        this.orthographicCamera = orthographicCamera;
    }

}
