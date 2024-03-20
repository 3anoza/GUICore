package com.i3anoza.guicore.components.common.windows;

import com.i3anoza.guicore.components.Component;
import com.i3anoza.guicore.core.Paddings;
import com.i3anoza.guicore.core.Rect;

import java.util.ArrayList;
import java.util.List;

public class Window {
    public int id;
    public Rect rect;
    public int minWidth;
    public int minHeight;
    public int renderOrder;
    public boolean isVisible = true;
    public boolean isMinimized = false;
    public Paddings border = Paddings.none;


    public final List<Component> components = new ArrayList<>();

}
