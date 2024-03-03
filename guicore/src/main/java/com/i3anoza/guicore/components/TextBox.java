package com.i3anoza.guicore.components;

import com.i3anoza.guicore.components.modules.ICallback;
import com.i3anoza.guicore.components.modules.IClicked;
import com.i3anoza.guicore.components.modules.IHovered;
import com.i3anoza.guicore.core.Rect;
import com.i3anoza.guicore.core.Vector2i;

import java.util.function.Consumer;

public class TextBox extends AComponent implements IClicked, ICallback<String>, IHovered {
    public String text;

    public TextBox(int componentId, Rect rect, String text) {
        super(componentId, rect);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw() {

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

    @Override
    public int addListener(Consumer<String> listener) {
        return 0;
    }

    @Override
    public void removeListener(Consumer<String> listener) {

    }

    @Override
    public void removeListener(int listenerId) {

    }

    @Override
    public void onHover(boolean isHovered) {

    }
}
