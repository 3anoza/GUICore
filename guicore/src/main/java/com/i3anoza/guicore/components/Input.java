package com.i3anoza.guicore.components;

import com.i3anoza.guicore.components.modules.ICallback;
import com.i3anoza.guicore.components.modules.IClicked;
import com.i3anoza.guicore.core.Rect;
import com.i3anoza.guicore.core.Vector2i;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Input extends AComponent implements IClicked, ICallback<String> {
    public Label placeholder;
    public String text;
    public int zLevel;

    private final List<Consumer<String>> listeners = new ArrayList<>();

    public Input(int componentId, Rect rect, Label placeholder, int zLevel) {
        super(componentId, rect);
        this.placeholder = placeholder;
        this.zLevel = zLevel;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw() {

    }

    @Override
    public int addListener(Consumer<String> listener) {
        listeners.add(listener);
        return listeners.size() - 1;
    }

    @Override
    public void removeListener(Consumer<String> listener) {
        listeners.remove(listener);
    }

    @Override
    public void removeListener(int listenerId) {
        listeners.remove(listenerId);
    }

    @Override
    public void onClick(Vector2i mousePos) {

    }

    @Override
    public void onHold() {

    }

    @Override
    public void onRelease() {

    }
}
