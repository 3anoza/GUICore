package com.i3anoza.guicore.components.modules;

import com.i3anoza.guicore.core.Vector2i;

public interface IClicked {
    void onClick(Vector2i mousePos);
    void onHold();
    void onRelease();
}
