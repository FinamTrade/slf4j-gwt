package ru.finam.slf4jgwt.showcase.client;

import com.google.gwt.core.client.EntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Showcase implements EntryPoint {
  private final Logger logger = LoggerFactory.getLogger(Showcase.class);

  @Override
  public void onModuleLoad() {
    logger.trace("hello world!");
    logger.debug("hello world!");
    logger.info("hello world!");
    logger.warn("hello world!");
    logger.error("hello world!");
    try {
      methodThrowingException();
    } catch (Exception e) {
      logger.error("oops", e);
    }
    throw new RuntimeException("uncaught exception");
  }

  private void methodThrowingException() throws Exception {
    throw new Exception("test exception");
  }
}
