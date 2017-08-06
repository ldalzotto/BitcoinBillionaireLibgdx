package com.ldz.component.score;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.Json;
import com.ldz.entity.Entity;
import com.ldz.entity.component.Component;
import com.ldz.entity.component.abs.InputComponent;
import com.ldz.entity.game.entity.ScoreEntity;

/**
 * Created by Loic on 07/08/2017.
 */
public class ScoreInputComponent extends InputComponent {

    private static final String TAG = ScoreInputComponent.class.getSimpleName();

    private Json json = new Json();

    public ScoreInputComponent(InputProcessor inputProcessor) {
        super(inputProcessor);
    }

    @Override
    public void receiveMessage(String message) {
        if(message == null)
            return;

        String[] messageReceived = message.split(Component.MESSAGE_TOKEN);

        if(messageReceived.length > 1){
            if(messageReceived[0].equalsIgnoreCase(MESSAGE.ADD_SCORE.toString())){
                Gdx.app.debug(TAG, "Message " + MESSAGE.ADD_SCORE.toString() + " reveived.");
                Integer scoreToadd = json.fromJson(Integer.class, messageReceived[1]);
                ((ScoreEntity)entityReference).addScore(scoreToadd);
            }
        }
    }

    @Override
    public void update(float delta) {
    }



    @Override
    public void setEntityReference(Entity entityReference) {
        super.setEntityReference(entityReference);
        ScoreInputProcessor scoreInputProcessor = (ScoreInputProcessor) this.inputProcessor;
        scoreInputProcessor.setEntityreference(entityReference);
    }

}
