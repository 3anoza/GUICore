package com.i3anoza.guicore.core.layouts;

import com.i3anoza.guicore.components.Component;

public class GridLayout extends Layout{
    public GridLayout(Component childrenContainer) {
        super(childrenContainer);
    }

    @Override
    public void updateChildren() {
        updateChildrenCommon();
    }

    @Override
    protected void positionChild(Component child, int startX, int startY, int containerWidth, int containerHeight, int childWidth, int childHeight, int i) {
        int spacingBetweenElements = spacing * (i + 1);

        child.rect.x = startX + childWidth * i + spacingBetweenElements;
        child.rect.y = startY + childHeight * i + spacingBetweenElements;
        child.rect.width = childWidth - spacing;
        child.rect.height = childHeight - spacing;
    }
}
