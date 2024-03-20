package com.i3anoza.guicore.components;

import com.i3anoza.guicore.core.Rect;
import com.i3anoza.guicore.core.enums.SelectableState;

import java.awt.*;

public class Selectable extends Component {
    public Color normal = Color.white;
    public Color pressed = Color.gray;
    public Color disabled = Color.darkGray;
    public Texture srcTexture;

    protected SelectableState selectableState = SelectableState.None;

    public Selectable(int id, Rect rect, int renderOrder, Texture texture) {
        super(id, rect, renderOrder);
        this.srcTexture = texture;
        this.srcTexture.disabled = disabled;
        srcTexture.setParent(this);
    }

    @Override
    public void render() {
        if (!isVisible) return;

        if (!children.isEmpty())
            children.forEach(component -> {
                component.isEnabled = isEnabled;
                component.render();
            });

        updateTextureColorToState();
        srcTexture.isEnabled = isEnabled;
        srcTexture.render();
    }

    protected void updateTextureColorToState() {
        srcTexture.background = selectableState == SelectableState.Pressed ? pressed : normal;
    }

    public void select() {
        if (!isEnabled || !isVisible || selectableState == SelectableState.Holden) return;
        selectableState = SelectableState.Pressed;
    }

    public void hold() {
        if (!isEnabled || !isVisible || selectableState != SelectableState.Pressed) return;
        selectableState = SelectableState.Holden;
    }

    public void release() {
        selectableState = SelectableState.None;
    }
}
