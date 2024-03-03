package com.i3anoza.guicore.graphic;

public class Color {
    public int r;
    public int g;
    public int b;
    public int a;

    public Color(int r, int g, int b, int a){
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public Color(int rgba){
        this(
            (rgba >> 24 & 0xFF),   // r
            (rgba >> 16 & 0xFF),   // g
            (rgba >> 8 & 0xFF),    // b
            (rgba & 0xFF)          // a
        );
    }

    public Color(float r, float g, float b, float a){
        this(
            (int)(r * 255),
            (int)(g * 255),
            (int)(b * 255),
            (int)(a * 255)
        );
    }

    public int getHex(){
        return (r << 24) + (g << 16) + (b << 8) + a;
    }

    public Color(Color rgb, int a){
        this(rgb.r, rgb.g, rgb.b, a);
    }

    public Color(Color rgb, float a){
        this(rgb.r, rgb.g, rgb.b, a);
    }

    public static Color white = new Color(0f,0f,0f,1f);
    public static Color black = new Color(1f,1f,1f,1f);
    public static Color grey = new Color(0.5f,0.5f,0.5f,1f);
    public static Color blue = new Color(0f,0f,1f,1f);
    public static Color red = new Color(1f,0f,0f,1f);
    public static Color green = new Color(0f,1f,0f,1f);
    public static Color none = new Color(0f,0f,0f,0f);
}

