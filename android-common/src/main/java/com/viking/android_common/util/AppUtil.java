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
package com.viking.android_common.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;

/**
 * Utility class for app
 * author : Viking Den <vikingden@live.com>
 * time   : 2016/8/6 16:00
 */
public class AppUtil {

    private AppUtil(){
        throw new UnsupportedOperationException("use static methods") ;
    }

    /**
     * open an application by package name
     *
     * @param context  The context to use.  Usually your {@link android.app.Application}
     *                 or {@link android.app.Activity} object.
     * @param packageName the package name of open application
     * @return if package name exist in system and opened ,return true ;otherwise ,return false
     */
    public static boolean openAppByPackageName(Context context, String packageName) {
        if (!TextUtils.isEmpty(packageName)) {
            PackageManager pm = context.getPackageManager();
            Intent launchIntentForPackage = pm.getLaunchIntentForPackage(packageName);
            if (launchIntentForPackage != null) {
                context.startActivity(launchIntentForPackage);
                return true;
            }
        }
        return false;
    }

    /**
     * Open application information activity by package name
     *
     * @param context   The context to use.  Usually your {@link android.app.Application}
     *                 or {@link android.app.Activity} object.
     * @param packageName the package name of open application
     * @return if package name exist in system and opened ,return true ; or return false ;
     */
    public static boolean openAppInfoByPackageName(Context context, String packageName) {
        if (!TextUtils.isEmpty(packageName)) {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + packageName));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK) ;
            context.startActivity(intent);
            return true;
        }
        return false;
    }

}
