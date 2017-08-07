package com.ldz.component.buyMenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.ldz.entity.component.abs.GraphicsComponent;
import com.ldz.entity.message.Message;

/**
 * Created by Loic on 07/08/2017.
 */
public class BuyMenuGraphicsComponent extends GraphicsComponent {

    private Texture textButton;

    public BuyMenuGraphicsComponent() {
        this.textButton = new Texture(Gdx.files.internal("menu/buy_button.png"));
    }

    @Override
    public void receiveMessage(Message message) {

    }

    @Override
    public void update(SpriteBatch spriteBatch, float delta, OrthographicCamera orthographicCamera) {
        Vector2 entityPosition = this.entityReference.getPosition();
        Rectangle rectangle = this.entityReference.getBoundingRectangle();
        Vector3 vector3 = orthographicCamera.project(new Vector3(rectangle.x, rectangle.y, 0));
        spriteBatch.draw(textButton, vector3.x, vector3.y, rectangle.width, rectangle.height);
    }
}
