package com.example.kuang.iluvbot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import trikita.anvil.RenderableView;
import static trikita.anvil.DSL.*;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new RenderableView(this) {
            @Override
            public void view() {
                xml(R.layout.activity_main, ()-> {
                    withId(R.id.text, ()->{
                        text("Hai");
                    });
                });
            }
        });
    }
}
