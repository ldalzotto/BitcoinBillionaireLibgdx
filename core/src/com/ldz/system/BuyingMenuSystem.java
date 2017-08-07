package com.ldz.system;

import com.ldz.entity.Entity;
import com.ldz.entity.EntityFactory;
import com.ldz.entity.message.Message;

/**
 * Created by Loic on 07/08/2017.
 */
public class BuyingMenuSystem extends System {

    private static BuyingMenuSystem instance = null;

    public static BuyingMenuSystem getInstance(){
        if(instance==null){
            instance=new BuyingMenuSystem();
        }
        return instance;
    }

    public BuyingMenuSystem() {
        initEntitys();
    }

    private void initEntitys(){
        this.entities.add(EntityFactory.getEntity(Entity.EntityType.BUY_MENU_BUTTON, this));
    }

    @Override
    public void sendMessageToAllEntities(Message message) {
        if(message.getMessageType().equals(Message.MESSAGE_TYPE.DISPLAY_BUY_MENU)){
                //add related entity
                entities.add(EntityFactory.getEntity(Entity.EntityType.BUY_MENU, this));
            }


        super.sendMessageToAllEntities(message);
    }
}
