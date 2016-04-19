package com.example.kuang.iluvbot;

import trikita.jedux.Action;
import trikita.jedux.Store;

/**
 * Created by kuang on 2016-04-19.
 */
public class MessageReducer implements Store.Reducer<Action, State> {

    @Override
    public State reduce(Action action, State state) {
        return ImmutableState.copyOf(state).withMessages(action.value.toString());
    }
}
