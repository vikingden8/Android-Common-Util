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
package com.viking.android_common.widgets;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 *
 *  Utility class for {@link android.widget.Toast}
 *
 */
public class VToast {

    /**
     * Show a special view by Toast, and with long time
     *
     * @param context The context to use.  Usually your {@link android.app.Application}
     *                 or {@link android.app.Activity} object.
     * @param view The view to show.
     */
    public static void makeViewL(Context context, View view){
        Toast toast = new Toast(context);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }

    /**
     * Show a special view by Toast, and with short time
     *
     * @param context The context to use.  Usually your {@link android.app.Application}
     *                 or {@link android.app.Activity} object.
     * @param view The view to show.
     */
    public static void makeViewS(Context context, View view){
        Toast toast = new Toast(context);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * Show text content by Toast , and with long time
     *
     * @param context The context to use.  Usually your {@link android.app.Application}
     *                 or {@link android.app.Activity} object.
     * @param resId The resource id of the string resource to use.
     */
    public static void makeTextL(Context context, int resId){
        Toast.makeText(context, resId, Toast.LENGTH_LONG).show();
    }

    /**
     * Show text content by Toast , and with shot time
     *
     * @param context The context to use.  Usually your {@link android.app.Application}
     *                 or {@link android.app.Activity} object.
     * @param resId The resource id of the string resource to use.
     */
    public static void makeTextS(Context context, int resId){
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
    }

    /**
     * Show text content by Toast , and with long time
     *
     * @param context The context to use.  Usually your {@link android.app.Application}
     *                 or {@link android.app.Activity} object.
     * @param content The text to show
     */
    public static void makeTextL(Context context, String content){
        Toast.makeText(context, content, Toast.LENGTH_LONG).show();
    }

    /**
     *Show text content by Toast , and with short time
     *
     * @param context The context to use.  Usually your {@link android.app.Application}
     *                 or {@link android.app.Activity} object.
     * @param content The text to show
     */
    public static void makeTextS(Context context, String content){
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

    /**
     * Show text content(formatted text with array args) by Toast , and with long time
     *
     * @param context The context to use.  Usually your {@link android.app.Application}
     *                 or {@link android.app.Activity} object.
     * @param formatResId The formatted resource id of the string resource to use
     * @param args Formatted text's args.
     */
    public static void makeTextL(Context context, int formatResId, Object... args){
        Toast.makeText(context, String.format(context.getString(formatResId), args), Toast.LENGTH_LONG).show();
    }

    /**
     * Show text content(formatted text with array args) by Toast , and with short time
     *
     * @param context The context to use.  Usually your {@link android.app.Application}
     *                 or {@link android.app.Activity} object.
     * @param formatResId The formatted resource id of the string resource to use
     * @param args Formatted text's args.
     */
    public static void makeTextS(Context context, int formatResId, Object... args){
        Toast.makeText(context, String.format(context.getString(formatResId), args), Toast.LENGTH_SHORT).show();
    }

    /**
     * Show text content(formatted text with array args) by Toast , and with long time
     *
     * @param context The context to use.  Usually your {@link android.app.Application}
     *                 or {@link android.app.Activity} object.
     * @param format The formatted text to show
     * @param args Formatted text's args.
     */
    public static void makeTextL(Context context, String format, Object... args){
        Toast.makeText(context, String.format(format, args), Toast.LENGTH_LONG).show();
    }

    /**
     * Show text content(formatted text with array args) by Toast , and with short time
     *
     * @param context The context to use.  Usually your {@link android.app.Application}
     *                 or {@link android.app.Activity} object.
     * @param format The formatted text to show
     * @param args Formatted text's args.
     */
    public static void makeTextS(Context context, String format, Object... args){
        Toast.makeText(context, String.format(format, args), Toast.LENGTH_SHORT).show();
    }
}
