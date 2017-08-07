package com.ldz.component.buyMenu;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.ldz.entity.component.abs.InputComponent;
import com.ldz.entity.message.DisplayBuyMenuMessage;
import com.ldz.entity.message.Message;
import com.ldz.input.MyInputMultiplexer;

/**
 * Created by Loic on 07/08/2017.
 */
public class BuyMenuInputComponent extends InputComponent {

    public BuyMenuInputComponent(BuyMenuInputProcessor inputProcessor) {
        super(inputProcessor);
        inputProcessor.setInputComponentReference(this);
    }

    @Override
    public void receiveMessage(Message message) {
        if(message.getMessageType().equals(Message.MESSAGE_TYPE.DISPLAY_BUY_MENU)){
            if(!((DisplayBuyMenuMessage)message).getValue()){
                entityReference.setIsDetroyable();
                MyInputMultiplexer.getInstance().removeProcessor(inputProcessor);
            }
        }
    }

    @Override
    public void update(float delta, OrthographicCamera orthographicCamera) {
        ((BuyMenuInputProcessor)inputProcessor).setOrthographicCamera(orthographicCamera);
    }
}
