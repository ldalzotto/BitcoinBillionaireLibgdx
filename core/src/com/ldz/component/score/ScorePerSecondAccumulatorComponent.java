package com.ldz.component.score;

import com.badlogic.gdx.utils.Json;
import com.ldz.entity.component.abs.BehaviorComponent;
import com.ldz.entity.game.entity.ScoreEntity;

/**
 * Created by Loic on 07/08/2017.
 */
public class ScorePerSecondAccumulatorComponent extends BehaviorComponent {

    private float timeAccumulator = 0;

    private Json json = new Json();

    @Override
    public void receiveMessage(String message) {

    }

    @Override
    public void update(float delta) {
        timeAccumulator += delta;
        if(timeAccumulator > 1){
            timeAccumulator = 0;
            ScoreEntity scoreEntity = (ScoreEntity) entityReference;
            scoreEntity.sendMessage(MESSAGE.ADD_SCORE, json.toJson(scoreEntity.getScorePerSecond()));
        }

    }
}
