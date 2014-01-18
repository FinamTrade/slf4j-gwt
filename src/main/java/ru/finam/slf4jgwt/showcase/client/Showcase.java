package ru.finam.slf4jgwt.showcase.client;

import com.google.gwt.core.client.EntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.finam.slf4jgwt.logging.util.Log;

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
    Log.d("DEBUG message using Log.d");
    Log.e("ERROR message using Log.e");
    Log.i("INFO message using Log.i");
    Log.t("TRACE message using Log.t");
    Log.w("WARN message using Log.w");
    throw new RuntimeException("uncaught exception");
  }

  private void methodThrowingException() throws Exception {
    throw new Exception("test exception");
  }
}
