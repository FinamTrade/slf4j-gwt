package ru.finam.slf4jgwt.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class GWTLoggerFactory implements ILoggerFactory {
    private final Map<String, Logger> loggers = new HashMap<String, Logger>();

    @Override
    public Logger getLogger(String name) {
        // the root logger is called "" in JUL
        if (Logger.ROOT_LOGGER_NAME.equalsIgnoreCase(name)) {
            name = "";
        }

        Logger logger = loggers.get(name);
        if (logger == null) {
            logger = new GWTLoggerAdapter(name);
            loggers.put(name, logger);
        }
        return logger;
    }
}