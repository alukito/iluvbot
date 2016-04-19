package com.example.kuang.iluvbot;

import org.immutables.value.Value;

import java.util.List;

/**
 * Created by kuang on 2016-04-19.
 */
@Value.Immutable
public interface State {
    List<String> messages();
}
