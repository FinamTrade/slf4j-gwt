package ru.finam.slf4jgwt.logging.console;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Andrei Korzhevskii <a.korzhevskiy@gmail.com>
 */
public class ConsoleLoggerFactory implements ILoggerFactory {
  private final Map<String, Logger> loggers = new HashMap<String, Logger>();

  @Override
  public Logger getLogger(String name) {
    Logger logger = loggers.get(name);
    if (logger == null) {
      logger = new ConsoleLoggerAdapter(name);
      loggers.put(name, logger);
    }
    return logger;
  }
}
