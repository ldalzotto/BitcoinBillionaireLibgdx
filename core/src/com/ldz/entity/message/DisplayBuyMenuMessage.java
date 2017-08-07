package com.ldz.entity.message;

/**
 * Created by Loic on 07/08/2017.
 */
public class DisplayBuyMenuMessage extends Message {

    public DisplayBuyMenuMessage(Boolean display) {
        super(MESSAGE_TYPE.DISPLAY_BUY_MENU, display);
    }

    public Boolean getValue(){
        return ((Boolean)valuesTransited.get(0));
    }

}
