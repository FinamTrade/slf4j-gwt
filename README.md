Simple slf4j api implementation for GWT
===

The aim of this project is to provide developers with an implementation of the
[Simple Logging Facade for Java (SLF4J 1.7.5)](http://www.slf4j.org/) API for the GWT client side.
Right now the project provides the basic implementation of the SLF4J API using the java.util.logging (JUL)
logging framework supported since GWT 2.1. All logging messages are printed to developer/firebug console.

Usage
---
slf4j-gwt is available in [maven central](http://search.maven.org/#artifactdetails%7Cru.finam%7Cslf4j-gwt%7C1.2%7Cjar)

Just include it in your pom.xml
```xml
<dependency>
    <groupId>ru.finam</groupId>
    <artifactId>slf4j-gwt</artifactId>
    <version>1.2</version>
</dependency>
```
or gradle build:
```groovy
dependencies {
    compile 'ru.finam:slf4j-gwt:1.2'
}
```

or ivy:
```xml
<dependency org="ru.finam" name="slf4j-gwt" rev="1.2" />
```

Add dependency in your gwt module descriptor (*.gwt.xml):
```xml
<inherits name="ru.finam.slf4jgwt.logging.gwt.Logging"/>
```

You can also set logging level (ALL, FINEST, FINER, FINE, CONFIG, INFO, WARNING, SEVERE):
```xml
<set-property name="gwt.logging.logLevel" value="INFO"/>
```

Enable or disable gwt logging:
```xml
<set-property name="gwt.logging.enabled" value="TRUE"/>
```

If you want to provide slf4j API (e.g., in library module):
```xml
<inherits name="ru.finam.slf4jgwt.api.API"/>
```

If you want to provide slf4j but to not log anything in your application:
```xml
<inherits name="ru.finam.slf4jgwt.logging.nop.NOP"/>
```

ru.finam.slf4jgwt.logging.util.Util module provides a handful Log class to
log messages without instantiating Logger in client code.