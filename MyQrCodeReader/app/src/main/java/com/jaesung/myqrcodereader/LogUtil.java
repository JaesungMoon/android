package com.jaesung.myqrcodereader;

import android.util.Log;

public class LogUtil {

    private static boolean isDebug = true;

    private static final String TAG = "MyQrCodeReader";

    private static final int TRACE_CALLER_COUNT = 2;

    public static void LOG_TRACE(String str) {
        if (isDebug) {
            Log.i(TAG, "[" + getClassName() + "::" + getFunctionName() + "] " + str);
        }
    }
    public static void LOG_WARNING(String str) {
        if (isDebug) {
            Log.w(TAG, "[" + getClassName() + "::" + getFunctionName() + "] " + str);
        }
    }

    private static String getClassName() {
        Throwable th = new Throwable();
        String fn = th.getStackTrace()[TRACE_CALLER_COUNT].getClassName();
        fn = fn.substring(fn.lastIndexOf(".") + 1);
        return fn;
    }

    private static String getFunctionName() {
        Throwable th = new Throwable();
        return th.getStackTrace()[TRACE_CALLER_COUNT].getMethodName();
    }
}
