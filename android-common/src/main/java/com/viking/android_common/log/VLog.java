/*
 * Copyright (C) 2016 Viking Den <vikingden@live.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.viking.android_common.log;

import android.app.Application;
import android.support.annotation.NonNull;
import android.text.TextUtils;

/**
 * This ia a aimple, pretty and powerful logger for android<br>
 * Base on <a href="https://github.com/ZhaoKaiQiang/KLog">KLog</a><br>
 * author : Viking Den <vikingden@live.com><p>
 * time   : 2016/10/26 22:29<p>
 */
public final class VLog {

    static final String NULL_TIPS = "Log with null object";

    private static final int STACK_TRACE_INDEX = 5;

    private static final String SUFFIX = ".java";

    private static final String TAG_DEFAULT = "VLog";

    private static final String PARAM = "Param";

    private static final String NULL = "null";

    static final int V = 0x1;
    static final int D = 0x2;
    static final int I = 0x3;
    static final int W = 0x4;
    static final int E = 0x5;
    static final int WTF = 0x6;

    private static Application mApplication ;

    private static LogConfiguration mConfig ;

    /**
     * <p>
     * Initialize VLog for a given Application.
     * </p>
     *
     * @param app   Your Application class.
     * @throws IllegalStateException if it is called more than once.
     */
    public static void init(@NonNull Application app){
        init(app , new LogConfigurationBuilder(app));
    }

    /**
     * <p>
     * Initialize VLog for a given Application.
     * </p>
     *
     * @param app     Your Application class.
     * @param builder LogConfigurationBuilder to manually set up VLog configuration.
     */
    public static void init(@NonNull Application app , @NonNull LogConfigurationBuilder builder){
        init(app , builder.build());
    }

    /**
     * <p>
     * Initialize VLog for a given Application.
     *
     * </p>
     *
     * @param app       Your Application class.
     * @param config    LogConfiguration to manually set up VLog configuration.
     * @throws IllegalStateException if it is called more than once.
     */
    public static void init(@NonNull Application app , LogConfiguration config){
        if (mApplication != null) {
            w("VLog#init called more than once. Won't do anything more.");
            return;
        }
        mApplication = app ;
        if (config == null) {
            w("VLog#init called but no LogConfiguration provided");
            return;
        }
        mConfig = config ;
    }

    public static void v(Object msg) {
        printLog(V, null, msg);
    }

    public static void v(String tag, Object... objects) {
        printLog(V, tag, objects);
    }

    public static void d(Object msg) {
        printLog(D, null, msg);
    }

    public static void d(String tag, Object... objects) {
        printLog(D, tag, objects);
    }

    public static void i(Object msg) {
        printLog(I, null, msg);
    }

    public static void i(String tag, Object... objects) {
        printLog(I, tag, objects);
    }

    public static void w(Object msg) {
        printLog(W, null, msg);
    }

    public static void w(String tag, Object... objects) {
        printLog(W, tag, objects);
    }

    public static void e(Object msg) {
        printLog(E, null, msg);
    }

    public static void e(String tag, Object... objects) {
        printLog(E, tag, objects);
    }

    public static void wtf(Object msg) {
        printLog(WTF, null, msg);
    }

    public static void wtf(String tag, Object... objects) {
        printLog(WTF, tag, objects);
    }

    private static void printLog(int type, String tagStr, Object... objects) {

        if (!mConfig.enableLogPrint()) {
            return;
        }

        String[] contents = wrapperContent(tagStr, objects);
        String tag = contents[0];
        String msg = contents[1];
        String headString = contents[2];

        switch (type) {
            case V:
            case D:
            case I:
            case W:
            case E:
            case WTF:
                BaseLog.printDefault(type, tag, headString + msg);
                break;
        }
    }

    private static String[] wrapperContent(String tagStr, Object... objects) {

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        StackTraceElement targetElement = stackTrace[STACK_TRACE_INDEX];
        String className = targetElement.getClassName();
        String[] classNameInfo = className.split("\\.");
        if (classNameInfo.length > 0) {
            className = classNameInfo[classNameInfo.length - 1] + SUFFIX;
        }

        if (className.contains("$")) {
            className = className.split("\\$")[0] + SUFFIX;
        }

        String methodName = targetElement.getMethodName();
        int lineNumber = targetElement.getLineNumber();

        if (lineNumber < 0) {
            lineNumber = 0;
        }

        String methodNameShort = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);

        String tag = (tagStr == null ? className : tagStr);

        if (mConfig.isLogTagEmpty() && TextUtils.isEmpty(tag)) {
            tag = TAG_DEFAULT;
        } else if (!mConfig.isLogTagEmpty()) {
            tag = mConfig.getLogTag();
        }

        String msg = (objects == null) ? NULL_TIPS : getObjectsString(objects);
        String headString = "[ (" + className + ":" + lineNumber + ")#" + methodNameShort + " ] ";

        return new String[]{tag, msg, headString};
    }

    private static String getObjectsString(Object... objects) {

        if (objects.length > 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\n");
            for (int i = 0; i < objects.length; i++) {
                Object object = objects[i];
                if (object == null) {
                    stringBuilder.append(PARAM).append("[").append(i).append("]").append(" = ").append(NULL).append("\n");
                } else {
                    stringBuilder.append(PARAM).append("[").append(i).append("]").append(" = ").append(object.toString()).append("\n");
                }
            }
            return stringBuilder.toString();
        } else {
            Object object = objects[0];
            return object == null ? NULL : object.toString();
        }
    }

}
