package ru.finam.slf4jgwt.logging.console;

import com.google.gwt.core.client.JsDate;
import com.google.gwt.core.shared.GWT;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;

/**
 * A LoggerAdapter that prints logs to the window.console.
 *
 * @author Andrei Korzhevskii <a.korzhevskiy@gmail.com>
 */
public class ConsoleLoggerAdapter extends MarkerIgnoringBase {
  private static final Level LEVEL = GWT.create(Level.class);

  public ConsoleLoggerAdapter(String name) {
    this.name = name;
  }

  @Override
  public boolean isTraceEnabled() {
    return isLoggable(Level.TRACE);
  }

  @Override
  public void trace(String msg) {
    log(Level.TRACE, msg, null);
  }

  @Override
  public void trace(String format, Object arg) {
    formatAndLog(Level.TRACE, format, arg);
  }

  @Override
  public void trace(String format, Object arg1, Object arg2) {
    formatAndLog(Level.TRACE, format, arg1, arg2);
  }

  @Override
  public void trace(String format, Object... argArray) {
    formatAndLog(Level.TRACE, format, argArray);
  }

  @Override
  public void trace(String msg, Throwable t) {
    log(Level.TRACE, msg, t);
  }

  @Override
  public boolean isDebugEnabled() {
    return isLoggable(Level.DEBUG);
  }

  @Override
  public void debug(String msg) {
    log(Level.DEBUG, msg, null);
  }

  @Override
  public void debug(String format, Object arg) {
    formatAndLog(Level.DEBUG, format, arg);
  }

  @Override
  public void debug(String format, Object arg1, Object arg2) {
    formatAndLog(Level.DEBUG, format, arg1, arg2);
  }

  @Override
  public void debug(String format, Object... argArray) {
    formatAndLog(Level.DEBUG, format, argArray);
  }

  @Override
  public void debug(String msg, Throwable t) {
    log(Level.DEBUG, msg, t);
  }

  @Override
  public boolean isInfoEnabled() {
    return isLoggable(Level.INFO);
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
    return isLoggable(Level.WARN);
  }

  @Override
  public void warn(String msg) {
    log(Level.WARN, msg, null);
  }

  @Override
  public void warn(String format, Object arg) {
    formatAndLog(Level.WARN, format, arg);
  }

  @Override
  public void warn(String format, Object arg1, Object arg2) {
    formatAndLog(Level.WARN, format, arg1, arg2);
  }

  @Override
  public void warn(String format, Object... argArray) {
    formatAndLog(Level.WARN, format, argArray);
  }

  @Override
  public void warn(String msg, Throwable t) {
    log(Level.WARN, msg, t);
  }

  @Override
  public boolean isErrorEnabled() {
    return isLoggable(Level.ERROR);
  }

  @Override
  public void error(String msg) {
    log(Level.ERROR, msg, null);
  }

  @Override
  public void error(String format, Object arg) {
    formatAndLog(Level.ERROR, format, arg);
  }

  @Override
  public void error(String format, Object arg1, Object arg2) {
    formatAndLog(Level.ERROR, format, arg1, arg2);
  }

  @Override
  public void error(String format, Object... argArray) {
    formatAndLog(Level.ERROR, format, argArray);
  }

  @Override
  public void error(String msg, Throwable t) {
    log(Level.ERROR, msg, t);
  }

  private void log(Level level, String msg, Throwable t) {
    if (isLoggable(level)) {
      log(name, level, msg, t);
    }
  }

  private void formatAndLog(Level level, String format, Object... argArray) {
    if (isLoggable(level)) {
      FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
      log(name, level, ft.getMessage(), ft.getThrowable());
    }
  }
  
  private static boolean isLoggable(Level level) {
    return Console.isEnabled() && level.intValue() >= LEVEL.intValue();
  }
  
  private static void log(String loggerName, Level level, String message,
                          Throwable throwable) {
    String formattedMessage = format(loggerName, level, message, throwable);

    if (level == Level.ERROR) {
      Console.error(formattedMessage);
    } else if (level == Level.WARN) {
      Console.warn(formattedMessage);
    } else if (level == Level.INFO) {
      Console.info(formattedMessage);
    } else {
      Console.log(formattedMessage);
    }
  }

  private static String format(String loggerName, Level level, String message,
                               Throwable throwable) {
    StringBuilder builder = new StringBuilder();
    builder.append(JsDate.create().toString());
    builder.append(" [");
    builder.append(level.getName());
    builder.append("] ");
    builder.append(loggerName);
    builder.append(" - ");
    builder.append(message);
    if (throwable != null) {
      throwable.printStackTrace(new StackTracePrintStream(builder));
    }
    return builder.toString();
  }
}
