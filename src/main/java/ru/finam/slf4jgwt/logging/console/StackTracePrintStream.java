/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package ru.finam.slf4jgwt.logging.console;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * A {@link java.io.PrintStream} implementation that implements only a subset of methods that is enough to
 * be used with {@link Throwable#printStackTrace(java.io.PrintStream)}.
 */
class StackTracePrintStream extends PrintStream {

  private final StringBuilder builder;

  public StackTracePrintStream(StringBuilder builder) {
    super((OutputStream) null);
    this.builder = builder;
  }

  @Override
  public final void print(Object obj) {
    print(String.valueOf(obj));
  }

  @Override
  public final void println(Object obj) {
    println(String.valueOf(obj));
  }

  @Override
  public final void print(String str) {
    builder.append(str);
  }

  @Override
  public final void println() {
    builder.append("\n");
  }

  @Override
  public final void println(String str) {
    print(str);
    println();
  }
}