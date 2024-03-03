package com.i3anoza.guicore.graphic;

import com.i3anoza.guicore.core.IResource;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface IGraphicRenderer {
     void drawShape(Color color, int x_dirty, int y_dirty, int w_dirty, int h_dirty, int zLvl_dirty);

     default void drawTexture(IResource resource, int x_dirty, int y_dirty, int w_dirty, int h_dirty, int zLvl_dirty){
         throw new NotImplementedException();
     }
}
