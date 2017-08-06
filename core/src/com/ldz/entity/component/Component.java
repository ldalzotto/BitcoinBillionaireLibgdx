package com.ldz.entity.component;

import com.ldz.entity.Entity;

/**
 * Created by Loic on 06/08/2017.
 */
public interface Component {

    String MESSAGE_TOKEN = ";;;;;;;;;;;";

    enum MESSAGE {
        ADD_SCORE;
    }

    void receiveMessage(String message);

    void setEntityReference(Entity entityReference);

}
