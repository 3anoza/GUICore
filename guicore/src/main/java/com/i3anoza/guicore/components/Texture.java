package com.i3anoza.guicore.components;

import com.i3anoza.guicore.core.CoreResource;
import com.i3anoza.guicore.core.Paddings;
import com.i3anoza.guicore.core.Rect;
import com.i3anoza.guicore.graphics.CoreRenderer;

import java.awt.*;

public class Texture extends Component{
    public Color background = Color.white;
    public Color disabled = Color.lightGray;
    public Paddings paddings = Paddings.none;
    public CoreResource srcImage;

    public Texture(int id, Rect rect, int renderOrder) {
        super(id, rect, renderOrder);
    }

    @Override
    public void render() {
        if (!isVisible) return;

        if (srcImage != null)
            CoreRenderer.graphicRenderer.drawTexture(srcImage, getRectWithPaddings(paddings), renderOrder);

        if (isEnabled)
            CoreRenderer.graphicRenderer.drawRect(background, getRectWithPaddings(paddings), renderOrder);
        else
            CoreRenderer.graphicRenderer.drawRect(disabled, getRectWithPaddings(paddings), renderOrder);
    }

    public Rect getRectWithPaddings(Paddings paddings){
        return new Rect(
                rect.x + paddings.left,
                rect.y + paddings.top,
                rect.width - paddings.left - paddings.right,
                rect.height - paddings.top - paddings.bottom
        );
    }
}
