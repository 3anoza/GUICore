package com.i3anoza.guicore.components.modules;

import java.util.function.Consumer;

public interface ICallback<T> {
    int addListener(Consumer<T> listener);
    void removeListener(Consumer<T> listener);
    void removeListener(int listenerId);
}
