package com.i3anoza.guicore.components;

import com.i3anoza.guicore.core.Rect;
import com.i3anoza.guicore.core.Vector2i;
import com.i3anoza.guicore.graphic.Color;
import com.i3anoza.guicore.graphic.Renderer;

public class Label extends AComponent { // TODO: implements IHovered, IClicked?
    public String text;
    public boolean dropShadow;
    public Vector2i paddings;

    public Label(int componentId, Rect rect, String text, boolean dropShadow) {
        this(componentId, rect, text, null, dropShadow);
    }

    public Label(int componentId, Rect rect, String text) {
        this(componentId, rect, text, null, false);
    }

    public Label(int componentId, Rect rect, String text, Vector2i paddings) {
        this(componentId, rect, text, paddings, false);
    }

    public Label(int componentId, Rect rect, String text, Vector2i paddings, boolean dropShadow) {
        super(componentId, rect);
        this.text = text;
        this.paddings = paddings;
        this.dropShadow = dropShadow;
    }

    @Override
    public void update() {}

    @Override
    public void draw() {
        Vector2i textPos = new Vector2i(
                rect.position.x + rect.resolution.width - Renderer.getStringWidth(text),
                rect.position.y + rect.resolution.height - Renderer.fontHeight
        );
        if (dropShadow)
            Renderer.drawStringWithShadow(text, textPos, Color.white);
        else
            Renderer.drawString(text, textPos, Color.white);
    }

}
