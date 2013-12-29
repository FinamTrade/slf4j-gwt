package ru.finam.slf4jgwt.logging.gwt;

import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A wrapper over {@link java.util.logging.Logger java.util.logging.Logger}
 * supported since GWT 2.1.
 *
 * @author Andrei Korzhevskii <a.korzhevskiy@gmail.com>
 */
public class GWTLoggerAdapter extends MarkerIgnoringBase {
  private final Logger logger;

  public GWTLoggerAdapter(String name) {
    this.name = name;
    logger = Logger.getLogger(name);
  }

  @Override
  public boolean isTraceEnabled() {
    return logger.isLoggable(Level.FINEST);
  }

  @Override
  public void trace(String msg) {
    log(Level.FINEST, msg, null);
  }

  @Override
  public void trace(String format, Object arg) {
    formatAndLog(Level.FINEST, format, arg);
  }

  @Override
  public void trace(String format, Object arg1, Object arg2) {
    formatAndLog(Level.FINEST, format, arg1, arg2);
  }

  @Override
  public void trace(String format, Object... argArray) {
    formatAndLog(Level.FINEST, format, argArray);
  }

  @Override
  public void trace(String msg, Throwable t) {
    log(Level.FINEST, msg, t);
  }

  @Override
  public boolean isDebugEnabled() {
    return logger.isLoggable(Level.FINE);
  }

  @Override
  public void debug(String msg) {
    log(Level.FINE, msg, null);
  }

  @Override
  public void debug(String format, Object arg) {
    formatAndLog(Level.FINE, format, arg);
  }

  @Override
  public void debug(String format, Object arg1, Object arg2) {
    formatAndLog(Level.FINE, format, arg1, arg2);
  }

  @Override
  public void debug(String format, Object... argArray) {
    formatAndLog(Level.FINE, format, argArray);
  }

  @Override
  public void debug(String msg, Throwable t) {
    log(Level.FINE, msg, t);
  }

  @Override
  public boolean isInfoEnabled() {
    return logger.isLoggable(Level.INFO);
  }

  @Override
  public void info(String msg) {
    log(Level.INFO, msg, null);
  }

  @Override
  public void info(String format, Object arg) {
    formatAndLog(Level.INFO, format, arg);
  }

  @Override
  public void info(String format, Object arg1, Object arg2) {
    formatAndLog(Level.INFO, format, arg1, arg2);
  }

  @Override
  public void info(String format, Object... argArray) {
    formatAndLog(Level.INFO, format, argArray);
  }

  @Override
  public void info(String msg, Throwable t) {
    log(Level.INFO, msg, t);
  }

  @Override
  public boolean isWarnEnabled() {
    return logger.isLoggable(Level.WARNING);
  }

  @Override
  public void warn(String msg) {
    log(Level.WARNING, msg, null);
  }

  @Override
  public void warn(String format, Object arg) {
    formatAndLog(Level.WARNING, format, arg);
  }

  @Override
  public void warn(String format, Object arg1, Object arg2) {
    formatAndLog(Level.WARNING, format, arg1, arg2);
  }

  @Override
  public void warn(String format, Object... argArray) {
    formatAndLog(Level.WARNING, format, argArray);
  }

  @Override
  public void warn(String msg, Throwable t) {
    log(Level.WARNING, msg, t);
  }

  @Override
  public boolean isErrorEnabled() {
    return logger.isLoggable(Level.SEVERE);
  }

  @Override
  public void error(String msg) {
    log(Level.SEVERE, msg, null);
  }

  @Override
  public void error(String format, Object arg) {
    formatAndLog(Level.SEVERE, format, arg);
  }

  @Override
  public void error(String format, Object arg1, Object arg2) {
    formatAndLog(Level.SEVERE, format, arg1, arg2);
  }

  @Override
  public void error(String format, Object... argArray) {
    formatAndLog(Level.SEVERE, format, argArray);
  }

  @Override
  public void error(String msg, Throwable t) {
    log(Level.SEVERE, msg, t);
  }

  private void log(Level level, String msg, Throwable t) {
    if (logger.isLoggable(level)) {
      logger.log(level, msg, t);
    }
  }

  private void formatAndLog(Level level, String format, Object... argArray) {
    if (logger.isLoggable(level)) {
      FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
      logger.log(level, ft.getMessage(), ft.getThrowable());
    }
  }
}