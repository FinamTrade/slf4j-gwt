package ru.finam.slf4jgwt.logging.console;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import ru.finam.slf4jgwt.impl.FastStringMap;

/**
 * ConsoleLoggerAdapter is an implementation of {@link org.slf4j.ILoggerFactory}
 * returning the appropriately named {@link ConsoleLoggerAdapter} instance.
 *
 * @author Andrei Korzhevskii <a.korzhevskiy@gmail.com>
 */
public class ConsoleLoggerFactory implements ILoggerFactory {
  private final FastStringMap<Logger> loggers = FastStringMap.create();

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
