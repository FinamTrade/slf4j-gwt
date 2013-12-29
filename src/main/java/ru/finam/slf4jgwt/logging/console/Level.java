package ru.finam.slf4jgwt.logging.console;

/**
 * @author Andrei Korzhevskii <a.korzhevskiy@gmail.com>
 */
public interface Level {
  Level TRACE = new LevelTrace();
  Level DEBUG = new LevelDebug();
  Level INFO = new LevelInfo();
  Level WARN = new LevelWarn();
  Level ERROR = new LevelError();

  public class LevelTrace implements Level {
    @Override
    public String getName() {
      return "TRACE";
    }

    @Override
    public int intValue() {
      return 0;
    }
  }

  public class LevelDebug implements Level {
    @Override
    public String getName() {
      return "DEBUG";
    }

    @Override
    public int intValue() {
      return 1;
    }
  }

  public class LevelInfo implements Level {
    @Override
    public String getName() {
      return "INFO";
    }

    @Override
    public int intValue() {
      return 2;
    }
  }

  public class LevelWarn implements Level {
    @Override
    public String getName() {
      return "WARN";
    }

    @Override
    public int intValue() {
      return 3;
    }
  }

  public class LevelError implements Level {
    @Override
    public String getName() {
      return "ERROR";
    }

    @Override
    public int intValue() {
      return 4;
    }
  }

  String getName();

  int intValue();
}
