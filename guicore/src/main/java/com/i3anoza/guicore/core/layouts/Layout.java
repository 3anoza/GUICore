package com.i3anoza.guicore.core.layouts;

import com.i3anoza.guicore.components.Component;
import com.i3anoza.guicore.core.Paddings;

public abstract class Layout {
    public int spacing = 0;
    public Paddings paddings = Paddings.none;

    protected final Component childrenContainer;

    public Layout(Component childrenContainer) {
        this.childrenContainer = childrenContainer;
    }

    public abstract void updateChildren();

    protected int[] calculateChildDimensions(int containerWidth, int containerHeight, int i) {
        int childWidth = (containerWidth / childrenContainer.getChildren().size());
        int childHeight = (containerHeight / childrenContainer.getChildren().size());
        return new int[] { childWidth, childHeight };
    }

    protected abstract void positionChild(Component child, int startX, int startY, int containerWidth, int containerHeight, int childWidth, int childHeight, int i);

    protected void updateChildrenCommon() {
        int containerWidth = childrenContainer.rect.width - paddings.left - paddings.right;
        int containerHeight = childrenContainer.rect.height - paddings.top - paddings.bottom;
        int startX = childrenContainer.rect.x + paddings.left;
        int startY = childrenContainer.rect.y + paddings.top;

        for (int i = 0; i < childrenContainer.getChildren().size(); i++) {
            Component child = childrenContainer.getChildren().get(i);

            int[] dimensions = calculateChildDimensions(containerWidth, containerHeight, i);
            int childWidth = dimensions[0];
            int childHeight = dimensions[1];

            positionChild(child, startX, startY, containerWidth, containerHeight, childWidth, childHeight, i);
        }
    }
}
