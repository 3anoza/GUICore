package com.i3anoza.guicore.components;

import com.i3anoza.guicore.core.CoreEvent;
import com.i3anoza.guicore.core.Rect;

public class CheckBox extends Selectable {

    public final CoreEvent<Boolean> onChange = new CoreEvent<>();

    public boolean isOn = true;
    public char checkSymbol = '✓';
    public Label checkSymbolContainer;

    public CheckBox(int id, Rect rect, int renderOrder, Texture srcTexture, Label label) {
        super(id, rect, renderOrder, srcTexture);
        this.checkSymbolContainer = label;
        checkSymbolContainer.setParent(this);
        checkSymbolContainer.text = String.valueOf(checkSymbol);
        checkSymbolContainer.onResize();
    }

    @Override
    public void render() {
        super.render();

        if (isOn)
            checkSymbolContainer.render();
    }

    @Override
    public void select() {
        super.select();
        isOn = !isOn;
        onChange.invoke(isOn);
    }
}
