package com.i3anoza.guicore.core;

// TODO this class is under question. Because it's only store a reference to an object
public class CoreResource {

    private final Object resource;

    public CoreResource(Object resource) {
        this.resource = resource;
    }

    public Object getResource(){
        return resource;
    }
}
