package ru.finam.slf4jgwt.logging.console;

import com.google.gwt.core.client.GWT;
import com.google.gwt.logging.client.LogConfiguration;

class Configuration {

  interface LoggingConfiguration {
    boolean isLoggingEnabled();

    boolean isLoggingEnabled(Level level);
  }

  static class LoggingConfigurationDisabled implements LoggingConfiguration {
    @Override
    public boolean isLoggingEnabled() {
      return false;
    }

    @Override
    public boolean isLoggingEnabled(Level level) {
      return false;
    }
  }

  static class LoggingConfigurationEnabled implements LoggingConfiguration {
    private final Level level = GWT.create(Level.class);

    @Override
    public boolean isLoggingEnabled() {
      return true;
    }

    @Override
    public boolean isLoggingEnabled(Level level) {
      return level.intValue() >= this.level.intValue();
    }
  }

  private static final LoggingConfiguration IMPL = GWT.create(LogConfiguration.class);

  public static boolean isLoggingEnabled() {
    return IMPL.isLoggingEnabled();
  }

  public static boolean isLoggingEnabled(Level level) {
    return IMPL.isLoggingEnabled(level);
  }

  private Configuration() {
  }
}
