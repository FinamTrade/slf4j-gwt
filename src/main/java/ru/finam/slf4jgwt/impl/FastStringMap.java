package ru.finam.slf4jgwt.impl;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A very fast map implemented using a {@link JavaScriptObject} when running
 * in production.
 *
 * @author Andrei Korzhevskii <a.korzhevskiy@gmail.com>
 */
public final class FastStringMap<V> extends JavaScriptObject {

  public static <V> FastStringMap<V> create() {
    return JavaScriptObject.createObject().cast();
  }

  protected FastStringMap() {
  }

  public native V get(String key) /*-{
    // Accesses must be prefixed with ':' to prevent conflict with built-in
    // JavaScript properties.
    var safeKey = ':' + key;
    return this[safeKey] || null;
  }-*/;

  public native void put(String key, V value) /*-{
    // Accesses must be prefixed with ':' to prevent conflict with built-in
    // JavaScript properties.
    var safeKey = ':' + key;
    this[safeKey] = value;
  }-*/;
}
