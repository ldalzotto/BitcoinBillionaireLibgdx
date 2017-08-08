package com.ldz.component.buyObjectButton;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.ldz.entity.component.abs.InputComponent;
import com.ldz.entity.message.Message;

/**
 * Created by Loic on 08/08/2017.
 */
public class BuyObjectButtonComponent extends InputComponent {

    public BuyObjectButtonComponent(BuyObjectInputProcessor inputProcessor) {
        super(inputProcessor);
        inputProcessor.setInputComponentReference(this);
    }

    @Override
    public void receiveMessage(Message message) {

    }

    @Override
    public void update(float delta, OrthographicCamera orthographicCamera) {
        ((BuyObjectInputProcessor)inputProcessor).setOrthographicCamera(orthographicCamera);
    }
}
