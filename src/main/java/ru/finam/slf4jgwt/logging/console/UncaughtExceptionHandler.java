package ru.finam.slf4jgwt.logging.console;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UncaughtExceptionHandler implements EntryPoint {
  @Override
  public void onModuleLoad() {
    if (GWT.getUncaughtExceptionHandler() == null) {
      final Logger logger = LoggerFactory.getLogger("");
      GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {
        @Override
        public void onUncaughtException(Throwable e) {
          logger.error("Uncaught exception", e);
        }
      });
    }
  }
}
