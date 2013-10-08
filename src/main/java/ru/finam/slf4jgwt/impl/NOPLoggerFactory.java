package ru.finam.slf4jgwt.impl;

import org.slf4j.Logger;

public class NOPLoggerFactory {
    public Logger getLogger(String name) {
        return NOPLogger.NOP_LOGGER;
    }

    public Logger getLogger(Class clazz) {
        return NOPLogger.NOP_LOGGER;
    }
}