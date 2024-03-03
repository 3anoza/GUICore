package com.i3anoza.guicore.graphic;

import com.i3anoza.guicore.core.Rect;
import com.i3anoza.guicore.core.Vector2i;
import com.i3anoza.guicore.core.IResource;

public class Renderer {
    private static IFontRenderer fontRenderer;
    private static IGraphicRenderer graphicRenderer;

    public static int fontHeight;

    public static void drawShape(Color color, Rect rect, int zLevel){
        graphicRenderer.drawShape(color, rect.position.x, rect.position.y, rect.resolution.width, rect.resolution.height, zLevel);
    }

    public static void drawTexture(IResource resource, Rect rect, int zLevel){
        graphicRenderer.drawTexture(resource, rect.position.x, rect.position.y, rect.resolution.width, rect.resolution.height, zLevel);
    }

    public static void drawStringWithShadow(String string, Vector2i pos, Color color){
        fontRenderer.drawStringWithShadow(string, pos.x, pos.y, color.getHex(), true);
    }

    public static void drawString(String string, Vector2i pos, Color color){
        fontRenderer.drawString(string, pos.x, pos.y, color.getHex());
    }

    public static int getStringWidth(String text){
        return fontRenderer.getStringWidth(text);
    }
}
