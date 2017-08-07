package com.ldz.system;

import com.ldz.entity.Entity;
import com.ldz.entity.EntityFactory;

/**
 * Created by Loic on 07/08/2017.
 */
public class BuyingMenuSystem extends System {

    public BuyingMenuSystem() {
        initEntitys();
    }

    private void initEntitys(){
        this.entities.add(EntityFactory.getEntity(Entity.EntityType.BUY_MENU, this));
    }

}
