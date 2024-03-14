package com.i3anoza.guicore.graphics;

import com.i3anoza.guicore.core.AResource;
import com.i3anoza.guicore.core.Rect;
import com.i3anoza.guicore.core.Vector2i;

public class CoreRenderer {
    public static AFontRenderer fontRenderer;
    public static AGraphicRenderer graphicRenderer;

    public static void init(AFontRenderer fRenderer, AGraphicRenderer gRenderer){
        fontRenderer = fRenderer;
        graphicRenderer = gRenderer;
    }
}
