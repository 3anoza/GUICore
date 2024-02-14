package com.i3anoza.guicore.core;

public class Rect {
    public Vector2i position;
    public Resolution resolution;

    public Rect(Vector2i position, Resolution resolution){
        this.position = position;
        this.resolution = resolution;
    }

    public Rect(int x, int y, int width, int height){
        this(new Vector2i(x, y), new Resolution(width, height));
    }

    public Rect(Rect rect){
        this.position = rect.position;
        this.resolution = rect.resolution;
    }
}
