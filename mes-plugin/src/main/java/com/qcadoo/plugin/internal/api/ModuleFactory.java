package com.qcadoo.plugin.internal.api;

import org.jdom.Element;

public interface ModuleFactory<T extends Module> {

    void postInitialize();

    T parse(String pluginIdentifier, Element node);

    String getIdentifier();

}