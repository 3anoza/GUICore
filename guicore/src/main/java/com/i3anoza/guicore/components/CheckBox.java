package com.i3anoza.guicore.components;

import com.i3anoza.guicore.components.modules.ICallback;
import com.i3anoza.guicore.components.modules.IClicked;
import com.i3anoza.guicore.core.Border;
import com.i3anoza.guicore.core.Rect;
import com.i3anoza.guicore.core.Vector2i;
import com.i3anoza.guicore.graphic.Color;
import com.i3anoza.guicore.graphic.Renderer;
import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CheckBox extends AComponent implements IClicked, ICallback<Boolean> {
    public final Label mark;
    public int zLevel;
    public boolean state;
    public boolean isClicked;
    public Border border;

    private final List<Consumer<Boolean>> listeners = new ArrayList<>();
    private final Task<Boolean> notifyTask = new Task<Boolean>() {
        @Override
        protected Boolean call() throws Exception {
            listeners.forEach(listener -> listener.accept(state));
            return null;
        }
    };

    public CheckBox(int componentId, Rect rect, Label mark, int zLevel) {
        super(componentId, rect);
        this.mark = mark;
        this.zLevel = zLevel;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw() {
        Renderer.drawShape(Color.white, rect, zLevel);
        if (isClicked){
            Rect drawingRect = border != null ? getRectWithoutBorder() : rect;
            Renderer.drawShape(Color.blue, drawingRect, zLevel + 1);
        }
        if (state){
            mark.draw();
        }
    }

    @Override
    public int addListener(Consumer<Boolean> listener) {
        listeners.add(listener);
        return listeners.size() - 1;
    }

    @Override
    public void removeListener(Consumer<Boolean> listener) {
        listeners.remove(listener);
    }

    @Override
    public void removeListener(int listenerId) {
        listeners.remove(listenerId);
    }

    @Override
    public void onClick(Vector2i mousePos) {
        state = !state;
        isClicked = true;
        if (notifyTask.isRunning())
            notifyTask.cancel();
        notifyTask.run();
    }

    @Override
    public void onHold() {
        if (!isClicked) return;
        isClicked = false;
    }

    @Override
    public void onRelease() {
        isClicked = false;
    }

    private Rect getRectWithoutBorder(){
        return new Rect(
                rect.position.x + border.leftTop.x,
                rect.position.y + border.leftTop.y,
                rect.resolution.width - border.rightBottom.x,
                rect.resolution.height - border.rightBottom.y
        );
    }
}
