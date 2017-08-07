package com.ldz.component.score;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.ldz.entity.Entity;
import com.ldz.entity.game.entity.ScoreEntity;
import com.ldz.entity.message.AddScoreMessage;

/**
 * Created by Loic on 07/08/2017.
 */
public class ScoreInputProcessor implements InputProcessor {

    private Entity entityreference;

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
        if(button == Input.Buttons.LEFT){
            entityreference.sendMessage(new AddScoreMessage(((ScoreEntity)entityreference).getScorePerClick()));
            return true;
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

    public void setEntityreference(Entity entityreference) {
        this.entityreference = entityreference;
    }
}
