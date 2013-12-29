package ru.finam.slf4jgwt.impl;

import com.google.gwt.core.shared.GWT;
import org.slf4j.ILoggerFactory;

/**
 * User: korzhevskiy
 * Date: 13.07.13
 */
public class Impl {
    public static final ILoggerFactory LOGGER_FACTORY = GWT.create(ILoggerFactory.class);

    private Impl() {
    }
}
