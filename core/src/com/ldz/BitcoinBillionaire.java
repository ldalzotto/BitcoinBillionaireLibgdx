package com.ldz;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.ldz.screen.ScreenManager;

/**
 * Created by Loic on 06/08/2017.
 */
public class BitcoinBillionaire extends Game {

    private ScreenManager _screenManager;

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        _screenManager = ScreenManager.getInstance();
        _screenManager.setScreen(ScreenManager.ScreenType.MAIN_GAME_SCREEN);
        setScreen(_screenManager.get_currentScreenDisplayed());
    }

    @Override
    public void dispose() {
        _screenManager.dispose();
    }
}
