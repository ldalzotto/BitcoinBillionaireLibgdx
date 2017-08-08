package com.ldz.entity.message;

/**
 * Created by Loic on 08/08/2017.
 */
public class TopDisplayLimitMessage extends Message {

    public TopDisplayLimitMessage(float valuesTransited) {
        super(MESSAGE_TYPE.TOP_DISPLAY_LIMIT, valuesTransited);
    }

    public float getValue(){
        return (float)this.valuesTransited.get(0);
    }
}
