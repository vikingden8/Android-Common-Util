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

import android.util.Log;

/**
 * handle base log print<br>
 * author : Viking Den <vikingden@live.com><br>
 * time   : 2016/10/26 22:52<br>
 */
final class BaseLog {

    static void printDefault(int type, String tag, String msg) {

        int index = 0;
        int maxLength = 4000;
        int countOfSub = msg.length() / maxLength;

        if (countOfSub > 0) {
            for (int i = 0; i < countOfSub; i++) {
                String sub = msg.substring(index, index + maxLength);
                printSub(type, tag, sub);
                index += maxLength;
            }
            printSub(type, tag, msg.substring(index, msg.length()));
        } else {
            printSub(type, tag, msg);
        }
    }

    static void printSub(int type, String tag, String sub) {
        switch (type) {
            case VLog.V:
                Log.v(tag, sub);
                break;
            case VLog.D:
                Log.d(tag, sub);
                break;
            case VLog.I:
                Log.i(tag, sub);
                break;
            case VLog.W:
                Log.w(tag, sub);
                break;
            case VLog.E:
                Log.e(tag, sub);
                break;
            case VLog.WTF:
                Log.wtf(tag, sub);
                break;
        }
    }
}
