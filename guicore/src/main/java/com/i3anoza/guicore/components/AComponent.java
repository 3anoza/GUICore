package com.i3anoza.guicore.components;

import com.i3anoza.guicore.core.Rect;

public abstract class AComponent {
    public final int componentId;
    public Rect rect;

    public AComponent(int componentId, Rect rect){
        this.componentId = componentId;
        this.rect = rect;
    }

    public abstract void update();
    public abstract void draw();
}
