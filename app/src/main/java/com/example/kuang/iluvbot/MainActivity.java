package com.example.kuang.iluvbot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import trikita.anvil.Anvil;
import trikita.anvil.RenderableView;
import trikita.anvil.recyclerview.Recycler;
import trikita.jedux.Action;
import trikita.jedux.Store;

import static trikita.anvil.DSL.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerAdapter radapter = new RecyclerAdapter();

        setContentView(new RenderableView(this) {
            @Override
            public void view() {
                xml(R.layout.activity_main, ()-> {
                    withId(R.id.recycler, ()-> {
                        Recycler.layoutManager(new LinearLayoutManager(getContext(),
                                LinearLayoutManager.VERTICAL, false));
                        Recycler.hasFixedSize(true);
                        Recycler.adapter(radapter.updateList(getState().messages()));
                    });

                    withId(R.id.send, () -> {
                        onClick((view) -> {
                            getStore().dispatch(new Action<>(Actions.NEW_MESSAGE, "woi"));
                        });
                        Anvil.unmount();
                    });
                });
            }
        });
    }

    private State getState() {
        return ((ILuvBotApp) getApplication()).getState();
    }

    private Store getStore() {
        return ((ILuvBotApp) getApplication()).getStore();
    }
}
