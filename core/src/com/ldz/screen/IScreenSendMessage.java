package com.ldz.screen;

import com.ldz.entity.component.Component;

/**
 * Created by Loic on 07/08/2017.
 */
public interface IScreenSendMessage {

    public void sendMessageToAllEntities(Component.MESSAGE messageType, String messageValue);

}
