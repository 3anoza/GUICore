package com.i3anoza.guicore.graphics;

public class CoreRenderer {
    public static AFontRenderer fontRenderer;
    public static AGraphicRenderer graphicRenderer;

    public static void init(AFontRenderer fRenderer, AGraphicRenderer gRenderer){
        fontRenderer = fRenderer;
        graphicRenderer = gRenderer;
    }
}
