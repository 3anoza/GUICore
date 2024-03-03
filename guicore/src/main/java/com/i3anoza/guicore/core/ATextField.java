package com.i3anoza.guicore.core;

import com.i3anoza.guicore.graphic.Color;
import com.i3anoza.guicore.graphic.IFontRenderer;

public abstract class ATextField {
    private final int componentId;
    private final IFontRenderer fontRenderer;
    private final Rect rect;

    public ATextField(int componentId, IFontRenderer fontRenderer, Rect rect){
        this.componentId = componentId;
        this.fontRenderer = fontRenderer;
        this.rect = rect;
    }

    public abstract void setMaxLength(int maxLength);
    public abstract void setTextColor(Color color);
    public abstract void setEnableBackgroundDrawing(boolean isEnable);
    public abstract void setCanLoseFocus(boolean isCan);
    public abstract void setText(String text);
    public abstract void updateCursorCounter();
    public abstract boolean isFocused();
    public abstract void mouseClicked(Vector2i mousePos, int mouseButton);
    public abstract boolean getVisible();

}
