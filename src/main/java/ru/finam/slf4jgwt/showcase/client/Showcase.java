package ru.finam.slf4jgwt.showcase.client;

import com.google.gwt.core.client.EntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Showcase implements EntryPoint {
  @Override
  public void onModuleLoad() {
    Logger logger = LoggerFactory.getLogger(getClass());
    logger.trace("hello world!");
    logger.debug("hello world!");
    logger.info("hello world!");
    logger.warn("hello world!");
    logger.error("hello world!");
  }
}
