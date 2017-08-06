package com.ldz.entity.component;

/**
 * Created by Loic on 06/08/2017.
 */
public interface Component {

    String MESSAGE_TOKEN = ";;;;;;;;;;;";

    enum MESSAGE {
        INIT_SCORE;
    }

    void receiveMessage(String message);

}
