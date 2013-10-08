Simple slf4j api implementation for GWT
===

The aim of this project is to provide developers with an implementation
of the [Simple Logging Facade for Java (SLF4J 1.7.5)](http://www.slf4j.org/) API for the GWT client side. Right now the project provides
the basic implementation of the SLF4J API using the java.util.logging (JUL)
logging framework supported since GWT 2.1. All logging messages are printed to developer/firebug console.

Usage
---
slf4j-gwt is available in [maven central](http://search.maven.org/#artifactdetails%7Cru.finam%7Cslf4j-gwt%7C1.0%7Cjar)

Just include it in your pom.xml
```xml
<dependency>
    <groupId>ru.finam</groupId>
    <artifactId>slf4j-gwt</artifactId>
    <version>1.0</version>
</dependency>
```
or gradle build:
```groovy
dependencies {
    compile 'ru.finam:slf4j-gwt:1.0'
}
```

or ivy:
```xml
<dependency org="ru.finam" name="slf4j-gwt" rev="1.0" />
```

Add dependency in your gwt module descriptor (*.gwt.xml)
and turn gwt logging on:
```xml
<inherits name="ru.finam.slf4jgwt.SLF4J"/>
<set-property name="gwt.logging.enabled" value="TRUE"/>
```

You can also set logging level:
```xml
<set-property name="gwt.logging.logLevel" value="INFO"/>
```

