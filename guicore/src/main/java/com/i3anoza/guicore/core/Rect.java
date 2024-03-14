package com.i3anoza.guicore.core;

public class Rect {
    public int x;
    public int y;
    public int width;
    public int height;

    public Rect(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean inBounds(Vector2i point){
        return point.x >= x && point.x <= x + width &&
                point.y >= y && point.y <= y + height;
    }
}
