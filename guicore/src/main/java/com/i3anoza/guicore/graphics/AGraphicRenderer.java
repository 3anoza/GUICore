package com.i3anoza.guicore.graphics;

import com.i3anoza.guicore.core.CoreResource;
import com.i3anoza.guicore.core.Rect;

import java.awt.*;

public abstract class AGraphicRenderer {
    public abstract void drawRect(Color color, Rect rect_dirty, int zLevel_dirty);
    public abstract void drawRect(Color color, Rect rect_dirty, int arcHeight, int arcWidth, int zLevel_dirty);
    public abstract void drawTexture(CoreResource resource, Rect rect_dirty, int zLevel_dirty);
}
