/*
 * Copyright (c) 2004-2013 QOS.ch
 * All rights reserved.
 *
 * Permission is hereby granted, free  of charge, to any person obtaining
 * a  copy  of this  software  and  associated  documentation files  (the
 * "Software"), to  deal in  the Software without  restriction, including
 * without limitation  the rights to  use, copy, modify,  merge, publish,
 * distribute,  sublicense, and/or sell  copies of  the Software,  and to
 * permit persons to whom the Software  is furnished to do so, subject to
 * the following conditions:
 *
 * The  above  copyright  notice  and  this permission  notice  shall  be
 * included in all copies or substantial portions of the Software.
 *
 * THE  SOFTWARE IS  PROVIDED  "AS  IS", WITHOUT  WARRANTY  OF ANY  KIND,
 * EXPRESS OR  IMPLIED, INCLUDING  BUT NOT LIMITED  TO THE  WARRANTIES OF
 * MERCHANTABILITY,    FITNESS    FOR    A   PARTICULAR    PURPOSE    AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE,  ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */
package ru.finam.gwt.slf4j.impl.client;

import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A wrapper over {@link java.util.logging.Logger java.util.logging.Logger} in
 * conformity with the {@link java.util.logging.Logger} interface. Note that the logging levels
 * mentioned in this class refer to those defined in the java.util.logging
 * package.
 *
 * @author Ceki G&uuml;lc&uuml;
 * @author Peter Royal
 * @author Andrey Korzhevskiy <a.korzhevskiy@gmail.com>
 */
public class GWTLoggerAdapter extends MarkerIgnoringBase {

    private final Logger logger;

    /**
     * Package access allows only {@link GWTLoggerFactory} to instantiate
     * SimpleLogger instances.
     */
    public GWTLoggerAdapter(String name) {
        this.name = name;
        logger = Logger.getLogger(name);
    }

    /**
     * Is this logger instance enabled for the FINEST level?
     *
     * @return True if this Logger is enabled for level FINEST, false otherwise.
     */
    public boolean isTraceEnabled() {
        return logger.isLoggable(Level.FINEST);
    }

    /**
     * Log a message object at level FINEST.
     *
     * @param msg
     *          - the message object to be logged
     */
    public void trace(String msg) {
        if (logger.isLoggable(Level.FINEST)) {
            log(Level.FINEST, msg, null);
        }
    }

    /**
     * Log a message at level FINEST according to the specified format and
     * argument.
     *
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for level FINEST.
     * </p>
     *
     * @param format
     *          the format string
     * @param arg
     *          the argument
     */
    public void trace(String format, Object arg) {
        if (logger.isLoggable(Level.FINEST)) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            log(Level.FINEST, ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log a message at level FINEST according to the specified format and
     * arguments.
     *
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the FINEST level.
     * </p>
     *
     * @param format
     *          the format string
     * @param arg1
     *          the first argument
     * @param arg2
     *          the second argument
     */
    public void trace(String format, Object arg1, Object arg2) {
        if (logger.isLoggable(Level.FINEST)) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            log(Level.FINEST, ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log a message at level FINEST according to the specified format and
     * arguments.
     *
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the FINEST level.
     * </p>
     *
     * @param format
     *          the format string
     * @param argArray
     *          an array of arguments
     */
    public void trace(String format, Object... argArray) {
        if (logger.isLoggable(Level.FINEST)) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
            log(Level.FINEST, ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log an exception (throwable) at level FINEST with an accompanying message.
     *
     * @param msg
     *          the message accompanying the exception
     * @param t
     *          the exception (throwable) to log
     */
    public void trace(String msg, Throwable t) {
        if (logger.isLoggable(Level.FINEST)) {
            log(Level.FINEST, msg, t);
        }
    }

    /**
     * Is this logger instance enabled for the FINE level?
     *
     * @return True if this Logger is enabled for level FINE, false otherwise.
     */
    public boolean isDebugEnabled() {
        return logger.isLoggable(Level.FINE);
    }

    /**
     * Log a message object at level FINE.
     *
     * @param msg
     *          - the message object to be logged
     */
    public void debug(String msg) {
        if (logger.isLoggable(Level.FINE)) {
            log(Level.FINE, msg, null);
        }
    }

    /**
     * Log a message at level FINE according to the specified format and argument.
     *
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for level FINE.
     * </p>
     *
     * @param format
     *          the format string
     * @param arg
     *          the argument
     */
    public void debug(String format, Object arg) {
        if (logger.isLoggable(Level.FINE)) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            log(Level.FINE, ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log a message at level FINE according to the specified format and
     * arguments.
     *
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the FINE level.
     * </p>
     *
     * @param format
     *          the format string
     * @param arg1
     *          the first argument
     * @param arg2
     *          the second argument
     */
    public void debug(String format, Object arg1, Object arg2) {
        if (logger.isLoggable(Level.FINE)) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            log(Level.FINE, ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log a message at level FINE according to the specified format and
     * arguments.
     *
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the FINE level.
     * </p>
     *
     * @param format
     *          the format string
     * @param argArray
     *          an array of arguments
     */
    public void debug(String format, Object... argArray) {
        if (logger.isLoggable(Level.FINE)) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
            log(Level.FINE, ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log an exception (throwable) at level FINE with an accompanying message.
     *
     * @param msg
     *          the message accompanying the exception
     * @param t
     *          the exception (throwable) to log
     */
    public void debug(String msg, Throwable t) {
        if (logger.isLoggable(Level.FINE)) {
            log(Level.FINE, msg, t);
        }
    }

    /**
     * Is this logger instance enabled for the INFO level?
     *
     * @return True if this Logger is enabled for the INFO level, false otherwise.
     */
    public boolean isInfoEnabled() {
        return logger.isLoggable(Level.INFO);
    }

    /**
     * Log a message object at the INFO level.
     *
     * @param msg
     *          - the message object to be logged
     */
    public void info(String msg) {
        if (logger.isLoggable(Level.INFO)) {
            log(Level.INFO, msg, null);
        }
    }

    /**
     * Log a message at level INFO according to the specified format and argument.
     *
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the INFO level.
     * </p>
     *
     * @param format
     *          the format string
     * @param arg
     *          the argument
     */
    public void info(String format, Object arg) {
        if (logger.isLoggable(Level.INFO)) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            log(Level.INFO, ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log a message at the INFO level according to the specified format and
     * arguments.
     *
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the INFO level.
     * </p>
     *
     * @param format
     *          the format string
     * @param arg1
     *          the first argument
     * @param arg2
     *          the second argument
     */
    public void info(String format, Object arg1, Object arg2) {
        if (logger.isLoggable(Level.INFO)) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            log(Level.INFO, ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log a message at level INFO according to the specified format and
     * arguments.
     *
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the INFO level.
     * </p>
     *
     * @param format
     *          the format string
     * @param argArray
     *          an array of arguments
     */
    public void info(String format, Object... argArray) {
        if (logger.isLoggable(Level.INFO)) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
            log(Level.INFO, ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log an exception (throwable) at the INFO level with an accompanying
     * message.
     *
     * @param msg
     *          the message accompanying the exception
     * @param t
     *          the exception (throwable) to log
     */
    public void info(String msg, Throwable t) {
        if (logger.isLoggable(Level.INFO)) {
            log(Level.INFO, msg, t);
        }
    }

    /**
     * Is this logger instance enabled for the WARNING level?
     *
     * @return True if this Logger is enabled for the WARNING level, false
     *         otherwise.
     */
    public boolean isWarnEnabled() {
        return logger.isLoggable(Level.WARNING);
    }

    /**
     * Log a message object at the WARNING level.
     *
     * @param msg
     *          - the message object to be logged
     */
    public void warn(String msg) {
        if (logger.isLoggable(Level.WARNING)) {
            log(Level.WARNING, msg, null);
        }
    }

    /**
     * Log a message at the WARNING level according to the specified format and
     * argument.
     *
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the WARNING level.
     * </p>
     *
     * @param format
     *          the format string
     * @param arg
     *          the argument
     */
    public void warn(String format, Object arg) {
        if (logger.isLoggable(Level.WARNING)) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            log(Level.WARNING, ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log a message at the WARNING level according to the specified format and
     * arguments.
     *
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the WARNING level.
     * </p>
     *
     * @param format
     *          the format string
     * @param arg1
     *          the first argument
     * @param arg2
     *          the second argument
     */
    public void warn(String format, Object arg1, Object arg2) {
        if (logger.isLoggable(Level.WARNING)) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            log(Level.WARNING, ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log a message at level WARNING according to the specified format and
     * arguments.
     *
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the WARNING level.
     * </p>
     *
     * @param format
     *          the format string
     * @param argArray
     *          an array of arguments
     */
    public void warn(String format, Object... argArray) {
        if (logger.isLoggable(Level.WARNING)) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
            log(Level.WARNING, ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log an exception (throwable) at the WARNING level with an accompanying
     * message.
     *
     * @param msg
     *          the message accompanying the exception
     * @param t
     *          the exception (throwable) to log
     */
    public void warn(String msg, Throwable t) {
        if (logger.isLoggable(Level.WARNING)) {
            log(Level.WARNING, msg, t);
        }
    }

    /**
     * Is this logger instance enabled for level SEVERE?
     *
     * @return True if this Logger is enabled for level SEVERE, false otherwise.
     */
    public boolean isErrorEnabled() {
        return logger.isLoggable(Level.SEVERE);
    }

    /**
     * Log a message object at the SEVERE level.
     *
     * @param msg
     *          - the message object to be logged
     */
    public void error(String msg) {
        if (logger.isLoggable(Level.SEVERE)) {
            log(Level.SEVERE, msg, null);
        }
    }

    /**
     * Log a message at the SEVERE level according to the specified format and
     * argument.
     *
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the SEVERE level.
     * </p>
     *
     * @param format
     *          the format string
     * @param arg
     *          the argument
     */
    public void error(String format, Object arg) {
        if (logger.isLoggable(Level.SEVERE)) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            log(Level.SEVERE, ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log a message at the SEVERE level according to the specified format and
     * arguments.
     *
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the SEVERE level.
     * </p>
     *
     * @param format
     *          the format string
     * @param arg1
     *          the first argument
     * @param arg2
     *          the second argument
     */
    public void error(String format, Object arg1, Object arg2) {
        if (logger.isLoggable(Level.SEVERE)) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            log(Level.SEVERE, ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log a message at level SEVERE according to the specified format and
     * arguments.
     *
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the SEVERE level.
     * </p>
     *
     * @param format
     *          the format string
     * @param arguments
     *          an array of arguments
     */
    public void error(String format, Object... arguments) {
        if (logger.isLoggable(Level.SEVERE)) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
            log(Level.SEVERE, ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log an exception (throwable) at the SEVERE level with an accompanying
     * message.
     *
     * @param msg
     *          the message accompanying the exception
     * @param t
     *          the exception (throwable) to log
     */
    public void error(String msg, Throwable t) {
        if (logger.isLoggable(Level.SEVERE)) {
            log(Level.SEVERE, msg, t);
        }
    }

    /**
     * Log the message at the specified level with the specified throwable if any.
     * This method creates a LogRecord and fills in caller date before calling
     * this instance's JDK14 logger.
     *
     * See bug report #13 for more details.
     *
     * @param level
     * @param msg
     * @param t
     */
    private void log(Level level, String msg, Throwable t) {
        logger.log(level, msg, t);
    }

}