package com.lysenkova.webservice.web.servicelocator;

import java.util.HashMap;
import java.util.Map;

public class ServiceLocator {
    private final  Map<Class, Object> registry = new HashMap<>();
    private final static ServiceLocator INSTANCE = new ServiceLocator();

    private ServiceLocator() {
    }

    public static ServiceLocator getInstance() {
        return INSTANCE;
    }

    public void register(Class clazz, Object service) {
        registry.put(clazz, service);
    }

    public <T> T getService(Class<T> clazz) {
        return clazz.cast(registry.get(clazz));
    }
}
