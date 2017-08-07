package com.ldz.entity.message;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Loic on 07/08/2017.
 */
public abstract class Message {

    protected MESSAGE_TYPE messageType;
    protected List<Object> valuesTransited;

    enum MESSAGE_TYPE {
        ADD_SCORE;
    }

    public Message(MESSAGE_TYPE messageType, Object... valuesTransited) {
        this.messageType = messageType;
        this.valuesTransited = Arrays.asList(valuesTransited);
    }

    public String getMessageType() {
        return messageType.toString();
    }

    public List<Object> getValuesTransited(){
        return valuesTransited;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageType=" + messageType +
                ", valuesTransited=" + valuesTransited +
                '}';
    }
}
