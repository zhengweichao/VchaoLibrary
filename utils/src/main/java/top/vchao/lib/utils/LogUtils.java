package top.vchao.lib.utils;

import android.util.Log;


/**
 * @ description： log工具类
 * @ author: vchao
 * @ blog: http://vchao.blog.csdn.net
 */
public class LogUtils {
    // 是否开启调试模式( true 打印log / false 不打印log )
    public static boolean DEBUG = true;
    // log的标志
    public static String LogTag = "vchao";

    private static String className;//类名
    private static String methodName;//方法名
    private static int lineNumber;//行数

    private static String createLog(String log) {
        return methodName + "(" + className + ":" + lineNumber + ")" + log;
    }

    private static void getMethodNames(StackTraceElement[] sElements) {
        className = sElements[1].getFileName();
        methodName = sElements[1].getMethodName();
        lineNumber = sElements[1].getLineNumber();
    }

    public static void e(String message) {
        if (DEBUG) {
            getMethodNames(new Throwable().getStackTrace());
            Log.e(LogTag, createLog(message));
        }
    }

    public static void i(String message) {
        if (DEBUG) {
            getMethodNames(new Throwable().getStackTrace());
            Log.i(LogTag, createLog(message));
        }
    }

    public static void d(String message) {
        if (DEBUG) {
            getMethodNames(new Throwable().getStackTrace());
            Log.d(LogTag, createLog(message));
        }
    }

    public static void w(String message) {
        if (DEBUG) {
            getMethodNames(new Throwable().getStackTrace());
            Log.w(LogTag, createLog(message));
        }
    }

    public static void v(String message) {
        if (DEBUG) {
            getMethodNames(new Throwable().getStackTrace());
            Log.v(LogTag, createLog(message));
        }
    }

}
