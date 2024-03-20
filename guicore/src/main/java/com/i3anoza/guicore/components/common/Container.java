package com.i3anoza.guicore.components.common;

import com.i3anoza.guicore.components.Component;
import com.i3anoza.guicore.core.Rect;
import com.i3anoza.guicore.core.layouts.Layout;

public class Container extends Component {
    private Layout layout;

    public Container(int id, Rect rect, int renderOrder) {
        super(id, rect, renderOrder);
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
        this.layout.updateChildren();
    }

    public void update(){
        layout.updateChildren();
    }

    @Override
    public void addChild(Component child) {
        super.addChild(child);
        layout.updateChildren();
    }

    @Override
    public void removeChild(Component child) {
        super.removeChild(child);
        layout.updateChildren();
    }

    @Override
    public void render() {
        if (!isVisible) return;

        if (!children.isEmpty())
            children.forEach(children -> {
            children.isEnabled = isEnabled;
            children.render();
        });
    }
}
