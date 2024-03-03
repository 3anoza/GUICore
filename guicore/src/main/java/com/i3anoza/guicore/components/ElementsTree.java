package com.i3anoza.guicore.components;

import com.i3anoza.guicore.components.models.TreeNode;
import com.i3anoza.guicore.components.modules.ICallback;
import com.i3anoza.guicore.components.modules.IClicked;
import com.i3anoza.guicore.components.modules.IHovered;
import com.i3anoza.guicore.core.Rect;
import com.i3anoza.guicore.core.Vector2i;
import com.i3anoza.guicore.graphic.Color;
import com.i3anoza.guicore.graphic.Renderer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ElementsTree extends AComponent implements IClicked, ICallback<Integer>, IHovered {

    public TreeNode tree;
    public int zLevel;

    private final List<Consumer<Integer>> listeners = new ArrayList<>();
    private TreeNode clickedNode;

    public ElementsTree(int componentId, Rect rect, int zLevel) {
        super(componentId, rect);
        this.zLevel = zLevel;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw() {
        Renderer.drawShape(Color.green, rect, zLevel);
        tree.draw();
        if (clickedNode != null){
            Renderer.drawShape(new Color(Color.blue, 0.5f), clickedNode.rect, zLevel + 1);
        }
    }

    @Override
    public int addListener(Consumer<Integer> listener) {
        listeners.add(listener);
        return listeners.size() - 1;
    }

    @Override
    public void removeListener(Consumer<Integer> listener) {
        listeners.remove(listener);
    }

    @Override
    public void removeListener(int listenerId) {
        listeners.remove(listenerId);
    }

    @Override
    public void onClick(Vector2i mousePos) {
        clickedNode = tree.findClickedNode(mousePos);
    }

    @Override
    public void onHold() {}

    @Override
    public void onRelease() {}

    @Override
    public void onHover(boolean isHovered) {

    }
}
