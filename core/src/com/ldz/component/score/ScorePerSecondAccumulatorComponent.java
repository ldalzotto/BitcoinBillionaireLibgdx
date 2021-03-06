package com.ldz.component.score;

import com.ldz.entity.component.abs.BehaviorComponent;
import com.ldz.entity.game.entity.ScoreEntity;
import com.ldz.entity.message.AddScoreMessage;
import com.ldz.entity.message.AddScorePerSecondMessage;
import com.ldz.entity.message.Message;

/**
 * Created by Loic on 07/08/2017.
 */
public class ScorePerSecondAccumulatorComponent extends BehaviorComponent {

    private float timeAccumulator = 0;

    @Override
    public void receiveMessage(Message message) {
        if (message.getMessageType().equals(Message.MESSAGE_TYPE.ADD_SCORE_PER_SECOND)) {
            AddScorePerSecondMessage addScoreMessage = (AddScorePerSecondMessage) message;
            ScoreEntity scoreEntity = (ScoreEntity) entityReference;
            scoreEntity.addToScorePerSecond(addScoreMessage.getScoreToAdd());
        }
    }

    @Override
    public void update(float delta) {
        timeAccumulator += delta;
        if (timeAccumulator > 1) {
            timeAccumulator = 0;
            ScoreEntity scoreEntity = (ScoreEntity) entityReference;
            scoreEntity.sendMessage(new AddScoreMessage(scoreEntity.getScorePerSecond()));
        }

    }
}
