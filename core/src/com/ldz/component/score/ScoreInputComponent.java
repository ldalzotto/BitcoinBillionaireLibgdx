package com.ldz.component.score;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.ldz.entity.Entity;
import com.ldz.entity.component.abs.InputComponent;
import com.ldz.entity.game.entity.ScoreEntity;
import com.ldz.entity.message.AddScoreMessage;
import com.ldz.entity.message.Message;

/**
 * Created by Loic on 07/08/2017.
 */
public class ScoreInputComponent extends InputComponent {

    private static final String TAG = ScoreInputComponent.class.getSimpleName();

    public ScoreInputComponent(InputProcessor inputProcessor) {
        super(inputProcessor);
    }

    @Override
    public void receiveMessage(Message message) {
        if(message == null)
            return;

        if(message instanceof AddScoreMessage) {
            AddScoreMessage addScoreMessage = (AddScoreMessage)message;
            Gdx.app.debug(TAG, "Message " + addScoreMessage.toString() + " reveived.");
            Integer scoreToadd = addScoreMessage.getScore();
            ((ScoreEntity)entityReference).addScore(scoreToadd);
        }
    }

    @Override
    public void update(float delta, OrthographicCamera orthographicCamera) {
    }

    @Override
    public void setEntityReference(Entity entityReference) {
        super.setEntityReference(entityReference);
        ScoreInputProcessor scoreInputProcessor = (ScoreInputProcessor) this.inputProcessor;
        scoreInputProcessor.setEntityreference(entityReference);
    }

}
