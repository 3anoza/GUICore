package com.i3anoza.guicore.components;

import com.i3anoza.guicore.core.Anchors;
import com.i3anoza.guicore.core.Rect;
import com.i3anoza.guicore.core.Vector2i;

import java.util.ArrayList;
import java.util.List;

public abstract class Component {
    public final int id;
    public Rect rect;
    public int renderOrder;
    public Anchors anchors = Anchors.leftTop;
    public boolean isVisible = true;
    public boolean isEnabled = true;

    protected Component parent;
    protected List<Component> children = new ArrayList<>();

    public Component(int id, Rect rect, int renderOrder) {
        this.id = id;
        this.rect = rect;
        this.renderOrder = renderOrder;
    }

    public abstract void render();


    public void setParent(Component parent){
        if (parent != null) {
            this.parent = parent;
            this.parent.addChild(this);
            onResize();
        }
    }

    public Component getParent(){
        return parent;
    }

    public List<Component> getChildren(){
        return children;
    }

    public void addChild(Component child){
        children.add(child);
        if (parent != null) {
            child.rect.x = moveXByAlign();
            child.rect.y = moveYByAlign();
        }
    }

    public void removeChild(Component child){
        children.remove(child);
        child.setParent(null);
    }

    public <T extends Component> T getChild(Class<T> child){
        return children.stream()
                .filter(child::isInstance)
                .findFirst()
                .map(child::cast)
                .orElseThrow(NullPointerException::new);
    }

    public <T extends Component> boolean hasChild(Class<T> child){
        return children.stream().anyMatch(child::isInstance);
    }

    public Vector2i getRelativePosition(){
        if (parent == null)
            return new Vector2i(rect.x, rect.y);

        return new Vector2i(rect.x + parent.rect.x, rect.y + parent.rect.y);
    }

    public void onResize(){
        if (parent != null){
            rect.x = moveXByAlign();
            rect.y = moveYByAlign();
        }
        children.forEach(Component::onResize);
    }

    protected int moveXByAlign(){
        switch (anchors.horizontal){
            case Center:
                return parent.rect.x + parent.rect.width / 2 - rect.width / 2;
            case Right:
                int distanceToRightBound = parent.rect.width - rect.x - rect.width;
                return parent.rect.x + parent.rect.width - distanceToRightBound - rect.width;
            case None:
                return rect.x;
        }
        return parent.rect.x;
    }

    protected int moveYByAlign(){
        switch (anchors.vertical){
            case Center:
                return parent.rect.y + parent.rect.height / 2 - rect.height / 2;
            case Bottom:
                int distanceToBottomBound = parent.rect.height - rect.y - rect.height;
                return parent.rect.y + parent.rect.height - distanceToBottomBound - rect.height;
            case None:
                return rect.y;
        }
        return parent.rect.y;
    }
}
