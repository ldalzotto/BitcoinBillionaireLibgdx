package com.ldz.component.buyMenu;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;
import com.ldz.component.input.processor.BasicInputProcessor;
import com.ldz.entity.message.DisplayBuyMenuMessage;
import com.ldz.system.BuyingMenuSystem;

/**
 * Created by Loic on 07/08/2017.
 */
public class BuyMenuInputProcessor extends BasicInputProcessor {

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
                    return true;
                }else {
                   BuyingMenuSystem.getInstance().sendMessageToAllEntities(new DisplayBuyMenuMessage(false));
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
