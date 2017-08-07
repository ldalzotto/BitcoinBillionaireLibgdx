package com.ldz.component.buyMenuButton;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.ldz.entity.component.abs.InputComponent;
import com.ldz.entity.message.Message;

/**
 * Created by Loic on 07/08/2017.
 */
public class BuyMenuButtonInputComponent extends InputComponent {

    public BuyMenuButtonInputComponent(BuyMenuButtonInputProcessor inputProcessor) {
        super(inputProcessor);
        inputProcessor.setInputComponentReference(this);
    }

    @Override
    public void receiveMessage(Message message) {

    }

    @Override
    public void update(float delta, OrthographicCamera orthographicCamera) {
        ((BuyMenuButtonInputProcessor)inputProcessor).setOrthographicCamera(orthographicCamera);
    }
}
