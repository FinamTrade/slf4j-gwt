package ru.finam.slf4jgwt.logging.nop;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

/**
 * GWTLoggerFactory is an implementation of {@link org.slf4j.ILoggerFactory}
 * always returns {@link NOPLogger} instance.
 *
 * @author Andrei Korzhevskii <a.korzhevskiy@gmail.com>
 */
public class NOPLoggerFactory implements ILoggerFactory {
  private final NOPLogger logger = new NOPLogger();

  @Override
  public Logger getLogger(String name) {
    return logger;
  }
}