package com.ldz.component.buyObjectButton;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;
import com.ldz.component.input.processor.BasicInputProcessor;
import com.ldz.entity.game.entity.BuyObjectButtonEntity;
import com.ldz.entity.message.BuyingObjectMessage;
import com.ldz.system.BuyingMenuSystem;

/**
 * Created by Loic on 08/08/2017.
 */
public class BuyObjectInputProcessor extends BasicInputProcessor {

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(orthographicCamera != null){
            if(button == Input.Buttons.LEFT){
                Vector3 unprojected =  orthographicCamera.unproject(new Vector3(screenX, screenY, 0));
                if(this.inputComponentReference.getEntityReference().getBoundingRectangle().contains(unprojected.x, unprojected.y)){
                    BuyingMenuSystem.getInstance().sendMessageToAllEntities(new BuyingObjectMessage((BuyObjectButtonEntity) this.inputComponentReference.getEntityReference()));
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
