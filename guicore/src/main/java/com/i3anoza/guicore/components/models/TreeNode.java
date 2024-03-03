package com.i3anoza.guicore.components.models;

import com.i3anoza.guicore.components.AComponent;
import com.i3anoza.guicore.core.Rect;
import com.i3anoza.guicore.core.Vector2i;

import java.util.List;

public class TreeNode {
    public AComponent value;
    public List<TreeNode> children;
    public Rect rect;
    public boolean isCollapsed;
    public boolean isExpandable;
    public int itemHeight;

    public TreeNode(AComponent value, Rect rect){
        this.value = value;
        this.rect = rect;
    }

    /**
     *
     * @param mousePos mouse position
     * @return true or false
     */
    public boolean isClicked(Vector2i mousePos){
        return rect.isPointInBounds(mousePos);
    }

    /**
     * Just a debug method for printing nodes tree
     * @param depth use 0, only influence on amount of tabs between nodes
     */
    public void dbg_printTree(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("\t");
        }
        System.out.println(sb.toString() + value);
        for (TreeNode child : children) {
            child.dbg_printTree(depth + 1);
        }
    }

    /**
     * Method to recursively check if any child node was clicked
     * @param mousePos mouse position
     * @return TreeNode or null
     */
    public TreeNode findClickedNode(Vector2i mousePos) {
        if (isClicked(mousePos)) {
            return this;
        }
        for (TreeNode child : children) {
            TreeNode clickedNode = child.findClickedNode(mousePos);
            if (clickedNode != null) {
                return clickedNode;
            }
        }
        return null;
    }

    public void draw(){
        value.draw();
        for (TreeNode child : children) {
            child.draw();
        }
    }
}
