package com.i3anoza.guicore.graphics;

import com.i3anoza.guicore.core.Vector2i;

import java.awt.*;

public abstract class AFontRenderer {
    public int fontHeight;

    public abstract void drawText(String text, Vector2i pos, Color color);
    public abstract void drawText(String text, Vector2i pos, Color color, boolean dropShadow);
    public abstract int getStringLen(String text);
    public abstract Object getObject();
}
