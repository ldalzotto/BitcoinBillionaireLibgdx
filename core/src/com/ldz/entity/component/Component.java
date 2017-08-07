package com.ldz.entity.component;

import com.ldz.entity.Entity;
import com.ldz.entity.message.Message;

/**
 * Created by Loic on 06/08/2017.
 */
public interface Component {

    void receiveMessage(Message message);

    void setEntityReference(Entity entityReference);

}
