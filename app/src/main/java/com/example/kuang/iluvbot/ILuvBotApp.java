package com.example.kuang.iluvbot;

import android.app.Application;

import trikita.anvil.Anvil;
import trikita.jedux.Action;
import trikita.jedux.Logger;
import trikita.jedux.Store;

/**
 * Created by kuang on 2016-04-19.
 */
public class ILuvBotApp extends Application {

    private Store<Action, State> store;

    @Override
    public void onCreate() {
        super.onCreate();
        this.store = new Store<>(new MessageReducer(),
                ImmutableState.builder().addMessages("woi").build());

        this.store.subscribe(Anvil::render);
    }

    public State getState() {
        return store.getState();
    }
}
