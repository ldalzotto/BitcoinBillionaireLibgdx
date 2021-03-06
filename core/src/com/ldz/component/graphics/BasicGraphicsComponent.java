package com.ldz.component.graphics;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.ldz.entity.component.abs.GraphicsComponent;
import com.ldz.entity.message.Message;

/**
 * Created by ldalzotto on 08/08/2017.
 */
public class BasicGraphicsComponent extends GraphicsComponent {

    private Texture texture;

    public BasicGraphicsComponent() {
        super();
    }

    @Override
    public void receiveMessage(Message message) {

    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    @Override
    public void update(SpriteBatch spriteBatch, float delta, OrthographicCamera orthographicCamera) {
        Vector2 entityPosition = this.entityReference.getPosition();
        Rectangle rectangle = this.entityReference.getBoundingRectangle();

        Vector2 oppositePoint = new Vector2(entityPosition.x + Math.abs(rectangle.width), entityPosition.y + Math.abs(rectangle.height));

        Vector3 vector3 = orthographicCamera.project(new Vector3(rectangle.x, rectangle.y, 0));
        Vector3 oppositePointProjected = orthographicCamera.project(new Vector3(oppositePoint.x, oppositePoint.y,0));

        spriteBatch.draw(texture, vector3.x, vector3.y, (oppositePointProjected.x - vector3.x), (oppositePointProjected.y - vector3.y));
    }
}
