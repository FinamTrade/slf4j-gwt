package ru.finam.slf4jgwt.logging.console;

import com.google.gwt.core.client.JsDate;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;

/**
 * A LoggerAdapter that prints logs to the window.console.
 *
 * @author Andrei Korzhevskii <a.korzhevskiy@gmail.com>
 */
public class ConsoleLoggerAdapter extends MarkerIgnoringBase {

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
    if (isLoggable(level) && Console.isSupported()) {
      log(name, level, msg, t);
    }
  }

  private void formatAndLog(Level level, String format, Object... argArray) {
    if (isLoggable(level) && Console.isSupported()) {
      FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
      log(name, level, ft.getMessage(), ft.getThrowable());
    }
  }
  
  private static boolean isLoggable(Level level) {
    return Configuration.isLoggingEnabled(level);
  }
  
  private static void log(String loggerName, Level level, String message,
                          Throwable throwable) {
    String formattedMessage = format(loggerName, level, message, throwable);

    int priority = level.getPriority();
    if (priority == Level.ERROR.getPriority()) {
      Console.error(formattedMessage);
    } else if (priority == Level.WARN.getPriority()) {
      Console.warn(formattedMessage);
    } else if (priority == Level.INFO.getPriority()) {
      Console.info(formattedMessage);
    } else {
      Console.log(formattedMessage);
    }
  }

  private static String format(String loggerName, Level level, String message,
                               Throwable throwable) {
    StringBuilder builder = new StringBuilder();
    builder.append(JsDate.create().toTimeString());
    builder.append(" ");
    builder.append(loggerName);
    builder.append("\n [");
    builder.append(level.getName());
    builder.append("] ");
    builder.append(message);
    if (throwable != null) {
      builder.append("\n");
      //TODO use throwable.printStackTrace(new StackTracePrintStream(builder));
      //when gwt 2.6 is out
      printStackTrace(builder, throwable);
    }
    return builder.toString();
  }

  private static void printStackTrace(StringBuilder builder, Throwable throwable) {
    for (Throwable t = throwable; t != null; t = t.getCause()) {
      if (t != throwable) {
        builder.append("Caused by: ");
      }
      builder.append(t).append("\n");
      for (StackTraceElement element : t.getStackTrace()) {
        builder.append("\tat ").append(element).append("\n");
      }
    }
  }
}
