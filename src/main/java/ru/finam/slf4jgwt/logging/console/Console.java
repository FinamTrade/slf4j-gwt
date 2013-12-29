package ru.finam.slf4jgwt.logging.console;

/**
 * Implements Console interface.
 *
 * @see com.google.gwt.logging.client.ConsoleLogHandler
 * Note we are consciously using 'window' rather than '$wnd' to avoid issues
 * similar to http://code.google.com/p/fbug/issues/detail?id=2914
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/console">
 *   Console - Web API interfaces</a>
 *
 * @author Andrei Korzhevskii <a.korzhevskiy@gmail.com>
 */
public class Console {
  private Console() {
  }

  public static native void error(String message) /*-{
      window.console.error(message);
  }-*/;

  public static native void info(String message) /*-{
      window.console.info(message);
  }-*/;

  public static native void log(String message) /*-{
      window.console.log(message);
  }-*/;

  public static native void trace() /*-{
      window.console.trace();
  }-*/;

  public static native void warn(String message) /*-{
      window.console.warn(message);
  }-*/;
}
