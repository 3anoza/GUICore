package com.i3anoza.guicore.core;

public class Paddings {
    public int left;
    public int top;
    public int right;
    public int bottom;

    public Paddings(int left, int right, int top, int bottom){
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
    }

    public static Paddings none = new Paddings(0,0,0,0);
}
