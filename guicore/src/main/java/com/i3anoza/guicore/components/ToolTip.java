package com.i3anoza.guicore.components;

import com.i3anoza.guicore.core.Rect;
import com.i3anoza.guicore.core.Vector2i;

public class ToolTip extends Component {
    public Label content;

    public ToolTip(int id, Rect rect, int renderOrder, Label content) {
        super(id, rect, renderOrder);
        this.content = content;
        addChild(content);
        content.setParent(this);
        isVisible = false;
    }

    @Override
    public void render() {
        if (!isVisible) return;
        children.forEach(Component::render);
    }

    public void show(Vector2i mousePos){
        rect.x = mousePos.x + 10;
        rect.y = mousePos.y + 10;
        children.forEach(Component::onResize);
        isVisible = true;
    }

    public void hide(){
        isVisible = false;
    }
}
