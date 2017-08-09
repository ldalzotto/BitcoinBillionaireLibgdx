package com.ldz.entity.message;

/**
 * Created by ldalzotto on 09/08/2017.
 */
public class AddScorePerSecondMessage extends Message {

    public AddScorePerSecondMessage(Integer valuesTransited) {
        super(MESSAGE_TYPE.ADD_SCORE_PER_SECOND, valuesTransited);
    }

    public Integer getScoreToAdd() {
        return (Integer) this.valuesTransited.get(0);
    }
}
