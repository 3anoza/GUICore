package com.i3anoza.guicore.graphic;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface IFontRenderer {
    void drawString(String text, int x, int y, int colorHex);
    void drawStringWithShadow(String text, float x, float y, int colorHex, boolean dropShadow);
    int getStringWidth(String text);
    Object getRendererObject();
}
