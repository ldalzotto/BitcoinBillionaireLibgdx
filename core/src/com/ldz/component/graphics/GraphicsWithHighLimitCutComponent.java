package com.ldz.component.graphics;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.ldz.entity.component.abs.GraphicsComponent;
import com.ldz.entity.message.DisplayBuyMenuMessage;
import com.ldz.entity.message.Message;
import com.ldz.entity.message.TopDisplayLimitMessage;

/**
 * Created by Loic on 08/08/2017.
 */
public class GraphicsWithHighLimitCutComponent extends GraphicsComponent {

    private Texture texture;

    private float highLimitDisplay;

    @Override
    public void receiveMessage(Message message) {
        if(message.getMessageType().equals(Message.MESSAGE_TYPE.DISPLAY_BUY_MENU)){
            if(!((DisplayBuyMenuMessage)message).getValue()){
                entityReference.setIsDetroyable();
            }
        } else if(message.getMessageType().equals(Message.MESSAGE_TYPE.TOP_DISPLAY_LIMIT)){
            highLimitDisplay = ((TopDisplayLimitMessage)message).getValue();
        }
    }

    @Override
    public void update(SpriteBatch spriteBatch, float delta, OrthographicCamera orthographicCamera) {
        Vector2 entityPosition = this.entityReference.getPosition();
        Rectangle rectangle = this.entityReference.getBoundingRectangle();
        Vector3 vector3 = orthographicCamera.project(new Vector3(rectangle.x, rectangle.y, 0));

        Vector2 oppositePoint = new Vector2(entityPosition.x + Math.abs(rectangle.width), entityPosition.y + Math.abs(rectangle.height));
        Vector3 oppositePointProjected = orthographicCamera.project(new Vector3(oppositePoint.x, oppositePoint.y,0));

        if((entityPosition.y + rectangle.height) > highLimitDisplay){
            int projectedWidth = (int)Math.abs(oppositePointProjected.x - oppositePoint.x);
            int projectedHeight = (int)Math.abs(oppositePointProjected.y - oppositePoint.y);
            TextureRegion textureRegion = new TextureRegion(texture, projectedWidth, (int)(projectedHeight-((entityPosition.y + projectedHeight) - highLimitDisplay)));
            spriteBatch.draw(textureRegion, vector3.x, vector3.y);
        }else {
            spriteBatch.draw(texture, vector3.x, vector3.y, (oppositePointProjected.x - vector3.x), (oppositePointProjected.y - vector3.y));
        }

    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }
}
