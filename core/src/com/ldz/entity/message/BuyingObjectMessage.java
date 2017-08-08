package com.ldz.entity.message;

import com.ldz.entity.game.entity.BuyObjectButtonEntity;

/**
 * Created by Loic on 08/08/2017.
 */
public class BuyingObjectMessage extends Message {

    public BuyingObjectMessage(BuyObjectButtonEntity buyObjectButtonEntity) {
        super(MESSAGE_TYPE.BUYING_OBJECT, buyObjectButtonEntity);
    }

    public BuyObjectButtonEntity getBuyObjectButtonEntity(){
        return (BuyObjectButtonEntity)this.valuesTransited.get(0);
    }
}
