package com.ldz.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Json;
import com.ldz.entity.Entity;
import com.ldz.entity.EntityFactory;
import com.ldz.entity.message.Message;
import com.ldz.screen.viewport.GlobalViewport;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Loic on 06/08/2017.
 */
public class MainGameScreen extends GlobalViewport implements Screen, IScreenSendMessage {

    private static final String TAG = MainGameScreen.class.getSimpleName();

    private SpriteBatch batch = null;
    private Camera camera;

    private static final int MAIN_GAME_SCREEN_HEIGHT = 960;
    private static final int MAIN_GAME_SCREEN_WIDTH = 640;

    private Json json;

    private List<Entity> entities;

    public MainGameScreen(){
            setupViewport(MAIN_GAME_SCREEN_WIDTH, MAIN_GAME_SCREEN_HEIGHT);

            json = new Json();
            batch = new SpriteBatch();

            entities = new ArrayList<Entity>();
        initializeScreen();
        //loadingAssets();

    }

    @Override
    public void show() {
        batch = new SpriteBatch();

        camera = new OrthographicCamera(VIEWPORT.getViewportWidth(), VIEWPORT.getViewportHeight());
        camera.update();
    }

    @Override
    public void render(float delta) {
        camera.update();

        Gdx.gl.glViewport(0, 0, (int)VIEWPORT.getViewportWidth(), (int)VIEWPORT.getViewportHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        batch.begin();
        entities.forEach(entity -> entity.update(delta,batch));
        batch.end();

        //Entity garbage collector
        List<Entity> entitiesToDestroy = entities.stream().filter(Entity::getIsDetroyable).collect(Collectors.toList());
        entitiesToDestroy.forEach(entities::remove);
    }

    private void initializeScreen(){
        entities.add(EntityFactory.getEntity(Entity.EntityType.BACKGROUND, this));
        entities.add(EntityFactory.getEntity(Entity.EntityType.SCORE, this));
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void sendMessageToAllEntities(Message message) {
        entities.forEach(entity -> entity.sendMessage(message));
    }
}
