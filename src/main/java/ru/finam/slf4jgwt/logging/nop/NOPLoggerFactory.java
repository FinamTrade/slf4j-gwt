package ru.finam.slf4jgwt.logging.nop;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

public class NOPLoggerFactory implements ILoggerFactory {
    private final NOPLogger logger = new NOPLogger();

    @Override
    public Logger getLogger(String name) {
        return logger;
    }
}