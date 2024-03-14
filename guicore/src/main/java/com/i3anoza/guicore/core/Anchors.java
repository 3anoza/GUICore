package com.i3anoza.guicore.core;

public class Anchors {
    public HorizontalAlign horizontal;
    public VerticalAlign vertical;

    public Anchors(HorizontalAlign h, VerticalAlign v){
        this.horizontal = h;
        this.vertical = v;
    }

    public static Anchors center = new Anchors(HorizontalAlign.Center, VerticalAlign.Center);
    public static Anchors centeredTop = new Anchors(HorizontalAlign.Center, VerticalAlign.Top);
    public static Anchors centeredBottom = new Anchors(HorizontalAlign.Center, VerticalAlign.Bottom);
    public static Anchors leftTop = new Anchors(HorizontalAlign.Left, VerticalAlign.Top);
    public static Anchors leftCentered = new Anchors(HorizontalAlign.Left, VerticalAlign.Center);
    public static Anchors rightBottom = new Anchors(HorizontalAlign.Right, VerticalAlign.Bottom);
    public static Anchors rightCentered = new Anchors(HorizontalAlign.Right, VerticalAlign.Center);
}
