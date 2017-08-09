package com.ldz.entity.game.entity;

import com.badlogic.gdx.math.Vector2;
import com.ldz.component.score.ScoreGraphicsComponent;
import com.ldz.component.score.ScoreInputComponent;
import com.ldz.entity.Entity;
import com.ldz.entity.component.abs.BehaviorComponent;
import com.ldz.entity.component.abs.PhysicsComponent;
import com.ldz.screen.IScreenSendMessage;

/**
 * Created by Loic on 06/08/2017.
 */
public class ScoreEntity extends Entity {

    private Integer currentScore;

    private Integer scorePerClick = 1;
    private Integer scorePerSecond = 4;

    public ScoreEntity(IScreenSendMessage iScreenSendMessage, ScoreInputComponent inputComponent, ScoreGraphicsComponent graphicsComponent, PhysicsComponent physicsComponent,
                       BehaviorComponent scoreAccumulatorComponent) {
        super(iScreenSendMessage, inputComponent, graphicsComponent, physicsComponent, scoreAccumulatorComponent);

        setPosition(new Vector2(20, 20));

        graphicsComponent.setEntityReference(this);
        inputComponent.setEntityReference(this);
        scoreAccumulatorComponent.setEntityReference(this);

        currentScore = 0;
    }

    public Integer getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(Integer currentScore) {
        this.currentScore = currentScore;
    }

    public void addScore(Integer scoreToAdd) {
        this.currentScore += scoreToAdd;
    }

    public Integer getScorePerClick() {
        return scorePerClick;
    }

    public Integer getScorePerSecond() {
        return scorePerSecond;
    }

    public void addToScorePerSecond(Integer scorePerSecondToAdd) {
        this.scorePerSecond += scorePerSecondToAdd;
    }
}
