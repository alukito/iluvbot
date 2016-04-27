package com.example.kuang.iluvbot;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import trikita.anvil.RenderableAdapter;
import trikita.anvil.RenderableRecyclerViewAdapter;

import static trikita.anvil.DSL.*;

/**
 * Created by andreas on 4/21/16.
 */
public class RecyclerAdapter extends RenderableRecyclerViewAdapter {
    private List<String> stringList = new ArrayList();

    public RecyclerAdapter updateList(List<String> newList) {
        if (!stringList.equals(newList)) {
            this.stringList = newList;
            notifyDataSetChanged();
        }
        return this;
    }

    @Override
    public void view(RecyclerView.ViewHolder holder) {
        String message = stringList.get(holder.getAdapterPosition());

        xml(R.layout.message_item, () -> {
            withId(R.id.message, () -> {
                text(message);
            });
        });
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }
}
