package com.ldz.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;

/**
 * Created by Loic on 07/08/2017.
 */
public class MyInputMultiplexer extends InputMultiplexer {

    private static MyInputMultiplexer instance = null;

    public static MyInputMultiplexer getInstance(){
        if (instance == null){
            instance = new MyInputMultiplexer();
            Gdx.input.setInputProcessor(instance);
        }
        return instance;
    }

}
