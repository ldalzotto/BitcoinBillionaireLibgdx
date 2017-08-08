package com.ldz.system;

import com.ldz.entity.Entity;
import com.ldz.entity.EntityFactory;
import com.ldz.entity.game.entity.BuyMenuEntity;
import com.ldz.entity.game.entity.BuyObjectButtonEntity;
import com.ldz.entity.game.entity.BuyableObjectDisplayEntity;
import com.ldz.entity.message.AddScoreMessage;
import com.ldz.entity.message.BuyingObjectMessage;
import com.ldz.entity.message.Message;
import com.ldz.entity.message.TopDisplayLimitMessage;
import com.ldz.screen.MainGameScreen;

import java.util.HashMap;
import java.util.Map;

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

    private Map<BuyObjectButtonEntity, BuyableObjectDisplayEntity> buyableObjectButtonToDisplay = new HashMap<>();

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
            buyableObjectButtonToDisplay.clear();
            BuyMenuEntity buyMenuEntity = (BuyMenuEntity)EntityFactory.getEntity(Entity.EntityType.BUY_MENU, this);
            entities.add(buyMenuEntity);

                //initialize childrens
            buyMenuEntity.getBuyableObjectsSlots().forEach(vector2 -> {
                BuyableObjectDisplayEntity entity = (BuyableObjectDisplayEntity)EntityFactory.getEntity(Entity.EntityType.BUYABLE_OBJECT_DISPLAY, this);
                entity.initializeEntityFromPosition(vector2);
                entities.add(entity);
                BuyObjectButtonEntity entity1 = (BuyObjectButtonEntity)EntityFactory.getEntity(Entity.EntityType.BUY_OBJECT_BUTTON, this);
                entity1.initializeEntityFromPosition(entity.getPosition());
                entities.add(entity1);
                buyableObjectButtonToDisplay.put(entity1, entity);
            });
            sendMessageToAllEntities(new TopDisplayLimitMessage(buyMenuEntity.getHighestPointOrdinate()));
        } else if(message.getMessageType().equals(Message.MESSAGE_TYPE.BUYING_OBJECT)){
            BuyingObjectMessage buyingObjectMessage =  (BuyingObjectMessage) message;
            //check which object is bought
            Entity entity = this.buyableObjectButtonToDisplay.get(buyingObjectMessage.getBuyObjectButtonEntity());
            if(entity != null){
                //Sending message to score
                BuyableObjectDisplayEntity buyingObjectDisplayEntity = (BuyableObjectDisplayEntity) entity;
                MainGameScreen.getInstance().sendMessageToAllEntities(new AddScoreMessage(buyingObjectDisplayEntity.getCostBonusPerSecond()));
            }

        }


        super.sendMessageToAllEntities(message);
    }
}
