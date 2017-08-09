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
 * <p>Entity managing the score displayed. Sends notification of ADD_SCORE every seconds to add score.</p>
 * <img src="doc-files/ScoreEntity.png" alt="ScoreEntity">
 */
/* @startuml  doc-files/ScoreEntity.png
    class ScoreEntity {
        + Int : currentScore
        + Int : scorePerClick
        + Int : scorePerSecond
    }
    class ScoreInputComponent {
    }
    class ScoreInputProcessor
    class ScoreGraphicsComponent {
    }
    class ScorePerSecondAccumulatorComponent {
        + float : timeAccumulator
    }
    class ADD_SCORE_MESSAGE << (S,#FF7700) >>
    class ADD_SCORE_PER_SECOND_MESSAGE << (S,#FF7700) >>

    ScoreEntity -down-> ScoreInputComponent
    ScoreEntity -down-> ScoreGraphicsComponent
    ScoreEntity -down-> ScorePerSecondAccumulatorComponent
    ScoreInputComponent -down-> ScoreInputProcessor
    ScoreInputProcessor --> ADD_SCORE_MESSAGE : Send add score \n `scorePerClick`
    ScorePerSecondAccumulatorComponent --> ADD_SCORE_PER_SECOND_MESSAGE : Send add score \n `scorePerSecond` every seconds
   @enduml
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
