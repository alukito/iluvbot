package com.example.kuang.iluvbot;

import java.util.List;

import trikita.jedux.Action;
import trikita.jedux.Store;
import static com.example.kuang.iluvbot.Actions.*;

/**
 * Created by kuang on 2016-04-19.
 */
public class MessageReducer implements Store.Reducer<Action<Actions, ?>, State> {

    @Override
    public State reduce(Action<Actions, ?> action, State state) {
        switch (action.type) {
            case NEW_MESSAGE :
                return ImmutableState.builder()
                        .from(state)
                        .addMessages((String) action.value)
                        .build();
            default:
                return state;

        }
    }
}
