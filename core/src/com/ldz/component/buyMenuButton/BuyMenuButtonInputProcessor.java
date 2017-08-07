package com.ldz.component.buyMenuButton;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.ldz.entity.component.abs.InputComponent;
import com.ldz.entity.message.DisplayBuyMenuMessage;
import com.ldz.system.BuyingMenuSystem;

/**
 * Created by Loic on 07/08/2017.
 */
public class BuyMenuButtonInputProcessor implements InputProcessor {

    private InputComponent inputComponentReference;
    private OrthographicCamera orthographicCamera;

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
                    BuyingMenuSystem.getInstance().sendMessageToAllEntities(new DisplayBuyMenuMessage(true));
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

    public InputComponent getInputComponentReference() {
        return inputComponentReference;
    }

    public void setInputComponentReference(InputComponent inputComponentReference) {
        this.inputComponentReference = inputComponentReference;
    }

    public void setOrthographicCamera(OrthographicCamera orthographicCamera) {
        this.orthographicCamera = orthographicCamera;
    }
}
