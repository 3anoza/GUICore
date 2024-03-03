package com.i3anoza.guicore.core;

import com.i3anoza.guicore.graphic.Color;

public class Border {
    public Color color;
    public Vector2i leftTop;
    public Vector2i rightBottom;

    public Border(Color color, Vector2i leftTop, Vector2i rightBottom){
        this.color = color;
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
    }
}
