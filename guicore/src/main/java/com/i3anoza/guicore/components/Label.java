package com.i3anoza.guicore.components;

import com.i3anoza.guicore.core.*;
import com.i3anoza.guicore.graphics.CoreRenderer;

import java.awt.*;

public class Label extends Component {
    public Color fontColor = Color.black;
    public int fontSize = CoreRenderer.fontRenderer.fontHeight;
    public CoreResource fontTexture = null; // means use default font
    public Anchors textAlign = Anchors.leftCentered;
    public Paddings paddings = Paddings.none;
    public boolean dropShadow = false;
    public String text;

    private final String interruptedText = "...";

    public Label(int id, Rect rect, int renderOrder) {
        super(id, rect, renderOrder);
        this.text = "label_"+id;
    }

    @Override
    public void render() {
        if (!isVisible) return;

        if (fontTexture != null)
            CoreRenderer.fontRenderer.drawText(fontTexture, text, getTextDrawingPosition(), fontColor, dropShadow);
        else
            CoreRenderer.fontRenderer.drawText(text, getTextDrawingPosition(), fontColor, dropShadow);
    }

    protected Vector2i getTextDrawingPosition() {
        Vector2i labelPosition = parent != null
                ? getRelativePosition()
                : new Vector2i(rect.x, rect.y);

        int textWidth = CoreRenderer.fontRenderer.getStringLen(text) - CoreRenderer.fontRenderer.getStringLen(interruptedText);

        return new Vector2i(
                getAlignedTextX(labelPosition.x + paddings.left, rect.width - paddings.right, textWidth),
                getAlignedTextY(labelPosition.y + paddings.top, rect.height - paddings.bottom, fontSize));
    }

    protected int getAlignedTextX(int x, int width, int textWidth){
        switch (textAlign.horizontal){
            case Center: return x + (width - textWidth) / 2;
            case Right: return x + width - textWidth;
        }
        return x;
    }

    protected int getAlignedTextY(int y, int height, int textHeight){
        switch (textAlign.vertical){
            case Center: return y + (height - textHeight) / 2;
            case Bottom: return y + height - textHeight;
        }
        return y;
    }
}
