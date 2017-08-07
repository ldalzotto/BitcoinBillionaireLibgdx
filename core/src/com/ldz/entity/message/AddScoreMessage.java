package com.ldz.entity.message;

import java.util.List;

/**
 * Created by Loic on 07/08/2017.
 */
public class AddScoreMessage extends Message {

    public AddScoreMessage(Integer score) {
        super(MESSAGE_TYPE.ADD_SCORE, score);
    }

    public Integer getScore() {
        List<Object> objects = super.getValuesTransited();
        Object score = objects.get(0);
        return ((Integer) score);
    }
}
