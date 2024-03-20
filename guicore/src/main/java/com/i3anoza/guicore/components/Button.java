package com.i3anoza.guicore.components;

import com.i3anoza.guicore.components.modules.IHoverable;
import com.i3anoza.guicore.core.CoreEvent;
import com.i3anoza.guicore.core.Rect;
import com.i3anoza.guicore.core.Vector2i;
import com.i3anoza.guicore.core.enums.SelectableState;

import java.awt.*;

public class Button extends Selectable implements IHoverable {

    public final CoreEvent<Void> onClick = new CoreEvent<>();

    public Color hover = Color.lightGray;
    public String tooltipText = "";

    private ToolTip toolTip;

    public Button(int id, Rect rect, int renderOrder, Texture srcTexture) {
        super(id, rect, renderOrder, srcTexture);
    }

    @Override
    public void hover(Vector2i mousePos) {
        if (!isVisible || !isEnabled ||
                selectableState == SelectableState.Holden ||
                selectableState == SelectableState.Pressed) return;

        selectableState = SelectableState.Hovered;

        toolTip = getChild(ToolTip.class);

        if (toolTip != null) {
            toolTip.content.text = tooltipText;
            toolTip.show(mousePos);
        }
    }

    @Override
    protected void updateTextureColorToState() {
        super.updateTextureColorToState();

        if (selectableState == SelectableState.Hovered) {
            srcTexture.background = hover;
        }
    }

    @Override
    public void unHover() {
        selectableState = SelectableState.None;
        if (toolTip != null) {
            toolTip.hide();
        }
    }

    @Override
    public void select() {
        super.select();
        unHover();
        onClick.invoke(null);
    }
}
