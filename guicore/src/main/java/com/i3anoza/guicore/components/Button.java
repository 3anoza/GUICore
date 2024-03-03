package com.i3anoza.guicore.components;

import com.i3anoza.guicore.components.modules.ICallback;
import com.i3anoza.guicore.components.modules.IClicked;
import com.i3anoza.guicore.components.modules.IHovered;
import com.i3anoza.guicore.core.Rect;
import com.i3anoza.guicore.core.Vector2i;
import com.i3anoza.guicore.graphic.Color;
import com.i3anoza.guicore.graphic.Renderer;
import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Button extends AComponent implements IHovered, IClicked, ICallback<Void> {

    public Image buttonImage;
    public Label buttonLabel;

    public int zLevel;
    public boolean isClicked;
    public boolean isHold;
    public boolean isHovered;

    private final List<Consumer<Void>> listeners = new ArrayList<>();

    private final Task<Void> notifyTask = new Task<Void>() {
        @Override
        protected Void call() throws Exception {
            listeners.forEach(listener -> listener.accept(null));
            return null;
        }
    };

    public Button(int componentId, Rect rect, int zLevel) {
        super(componentId, rect);
        this.zLevel = zLevel;
    }

    public Button(int componentId, Rect rect, int zLevel, Image buttonImage) {
        this(componentId, rect, zLevel);
        this.buttonImage = buttonImage;
    }

    public Button(int componentId, Rect rect, int zLevel, Label buttonLabel) {
        this(componentId, rect, zLevel);
        this.buttonLabel = buttonLabel;
    }

    @Override
    public void update() {}

    @Override
    public void draw() {
        if (isClicked || isHold || isHovered){
            Renderer.drawShape(Color.white, rect, zLevel);
        }else {
            Renderer.drawShape(Color.grey, rect, zLevel);
        }
        if (buttonLabel != null){
            buttonLabel.draw();
        }
        if (buttonImage != null){
            buttonImage.draw();
        }
    }

    @Override
    public int addListener(Consumer<Void> listener) {
        listeners.add(listener);
        return listeners.size() - 1;
    }

    @Override
    public void removeListener(Consumer<Void> listener) {
        listeners.remove(listener);
    }

    @Override
    public void removeListener(int listenerId) {
        listeners.remove(listenerId);
    }

    @Override
    public void onClick(Vector2i mousePos) {
        isClicked = true;
        if (notifyTask.isRunning())
            notifyTask.cancel();
        notifyTask.run();
    }

    @Override
    public void onHold() {
        if (!isClicked) return;
        isClicked = false;
        isHold = true;
    }

    @Override
    public void onRelease() {
        isClicked = false;
        isHold = false;
    }

    @Override
    public void onHover(boolean isHovered) {
        this.isHovered = isHovered;
    }
}
