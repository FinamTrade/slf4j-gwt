package ru.finam.gwt.slf4j.impl.client;

import com.google.gwt.core.client.GWT;

/**
 * User: korzhevskiy
 * Date: 13.07.13
 */
public final class Impl {
    public static final NOPLoggerFactory LOGGER_FACTORY = GWT.create(NOPLoggerFactory.class);

    private Impl() {
    }
}
