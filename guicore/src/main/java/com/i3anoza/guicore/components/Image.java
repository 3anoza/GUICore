package com.i3anoza.guicore.components;

import com.i3anoza.guicore.core.Border;
import com.i3anoza.guicore.core.Rect;
import com.i3anoza.guicore.graphic.Color;
import com.i3anoza.guicore.graphic.Renderer;
import com.i3anoza.guicore.core.IResource;

public class Image extends AComponent{
    public IResource imgSource;
    public int zLevel;
    public Color mask;
    public Border border;

    public Image(int componentId, Rect rect, IResource imgSource, int zLevel) {
        super(componentId, rect);
        this.imgSource = imgSource;
        this.zLevel = zLevel;
    }

    @Override
    public void update() {}

    @Override
    public void draw() {
        if (border != null) {
            Renderer.drawTexture(imgSource, getRectWithoutBorder(), zLevel);
            Renderer.drawShape(border.color, rect, zLevel - 1);
        }else
            Renderer.drawTexture(imgSource, rect, zLevel);

        if (mask != null)
            Renderer.drawShape(mask, rect, zLevel + 1);
    }

    private Rect getRectWithoutBorder(){
        return new Rect(
                rect.position.x + border.leftTop.x,
                rect.position.y + border.leftTop.y,
                rect.resolution.width - border.rightBottom.x,
                rect.resolution.height - border.rightBottom.y
        );
    }
}
