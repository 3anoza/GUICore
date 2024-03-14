package com.i3anoza.guicore.graphics;

import com.i3anoza.guicore.core.AResource;
import com.i3anoza.guicore.core.Rect;

import java.awt.*;

public abstract class AGraphicRenderer {
    public abstract void drawColor(Color color, Rect rect_dirty, int zLevel_dirty);
    public abstract void drawTexture(AResource resource, Rect rect_dirty, int zLevel_dirty);
}
