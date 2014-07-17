package ru.finam.slf4jgwt.logging.gwt;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import java.util.HashMap;

/**
 * GWTLoggerFactory is an implementation of {@link org.slf4j.ILoggerFactory}
 * returning the appropriately named {@link GWTLoggerAdapter} instance.
 *
 * @author Andrei Korzhevskii <a.korzhevskiy@gmail.com>
 */
public class GWTLoggerFactory implements ILoggerFactory {
  private final HashMap<String, Logger> loggers = new HashMap<String, Logger>();

  @Override
  public Logger getLogger(String name) {
    if (name == null) {
      throw new NullPointerException();
    }

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