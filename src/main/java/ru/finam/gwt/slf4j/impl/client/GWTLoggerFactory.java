package ru.finam.gwt.slf4j.impl.client;

import org.slf4j.Logger;

import java.util.HashMap;

public final class GWTLoggerFactory extends NOPLoggerFactory {
    private final HashMap<String, Logger> loggerMap = new HashMap<String, Logger>();

    @Override
    public Logger getLogger(String name) {
        // the root logger is called "" in JUL
        if (Logger.ROOT_LOGGER_NAME.equalsIgnoreCase(name)) {
            name = "";
        }

        Logger logger = loggerMap.get(name);
        if (logger == null) {
            logger = new GWTLoggerAdapter(name);
            loggerMap.put(name, logger);
        }
        return logger;
    }

    @Override
    public Logger getLogger(Class clazz) {
        return getLogger(clazz.getName());
    }
}