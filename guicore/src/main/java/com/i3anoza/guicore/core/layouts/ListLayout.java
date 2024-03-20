package com.i3anoza.guicore.core.layouts;

import com.i3anoza.guicore.components.Component;
import com.i3anoza.guicore.core.Paddings;

public class ListLayout extends Layout {
    private final boolean isVertical;

    public ListLayout(Component childrenContainer, boolean isVertical) {
        super(childrenContainer);
        this.isVertical = isVertical;
    }

    @Override
    public void updateChildren() {
        updateChildrenCommon();
    }

    @Override
    protected void positionChild(Component child, int startX, int startY, int containerWidth, int containerHeight, int childWidth, int childHeight, int i) {
        int spacingBetweenElements = spacing * (i + 1);

        if (isVertical) {
            int occupiedHeight = childHeight * i;
            child.rect.x = startX;
            child.rect.y = startY + occupiedHeight + spacingBetweenElements;
            child.rect.width = containerWidth;
            child.rect.height = childHeight - spacing;
        } else {
            int occupiedWidth = childWidth * i;
            child.rect.x = startX + occupiedWidth + spacingBetweenElements;
            child.rect.y = startY;
            child.rect.width = childWidth - spacing;
            child.rect.height = containerHeight;
        }
    }
}