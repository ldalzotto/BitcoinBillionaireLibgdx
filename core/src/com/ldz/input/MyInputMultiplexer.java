package com.ldz.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.ldz.config.input.InputMultiplexerConfig;

import java.util.HashMap;
import java.util.Map;

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

    @Override
    public void addProcessor(InputProcessor processor) {
        super.addProcessor(processor);
        setProcessorWithPriority();
    }

    @Override
    public void removeProcessor(InputProcessor processor) {
        super.removeProcessor(processor);
        setProcessorWithPriority();
    }

    private void setProcessorWithPriority(){

        Map<String, InputProcessor> inputProcessorMap = new HashMap<>();

        for (InputProcessor inputProcessor :
                this.getProcessors()) {
            inputProcessorMap.put(inputProcessor.getClass().getSimpleName(), inputProcessor);
        }

        //remove all processor
        this.clear();

        InputMultiplexerConfig.getInstance().getInputProcessors().getInputprocessors().forEach(inputProcessorDetail -> {
            if(inputProcessorMap.get(inputProcessorDetail.getName()) != null){
                super.addProcessor(inputProcessorMap.get(inputProcessorDetail.getName()));
            }
        });
    }

}
