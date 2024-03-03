package com.i3anoza.guicore.components;

import com.i3anoza.guicore.core.Rect;
import com.i3anoza.guicore.graphic.Color;
import com.i3anoza.guicore.graphic.Renderer;

public class Tooltip extends AComponent {
    public Label tip;
    public int zLevel;

    public boolean enable = true;

    public Tooltip(int componentId, Rect rect, Label tip, int zLevel) {
        super(componentId, rect);
        this.tip = tip;
        this.zLevel = zLevel;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw() {
        if (enable){
            Renderer.drawShape(Color.grey, rect, zLevel);
            tip.draw();
        }
    }
}
