package ru.finam.slf4jgwt.logging.console;

/**
 *
 * @author Andrei Korzhevskii <a.korzhevskiy@gmail.com>
 */
public class Console {
  private Console() {
  }

  public static native void debug(String message) /*-{
      window.console.debug(message);
  }-*/;

  public static native void trace(String message) /*-{
      window.console.trace(message);
  }-*/;

  public static native void error(String message) /*-{
      window.console.error(message);
  }-*/;

  public static native void warn(String message) /*-{
      window.console.warn(message);
  }-*/;

  public static native void info(String message) /*-{
      window.console.info(message);
  }-*/;

  public static native void log(String message) /*-{
      window.console.log(message);
  }-*/;
}
