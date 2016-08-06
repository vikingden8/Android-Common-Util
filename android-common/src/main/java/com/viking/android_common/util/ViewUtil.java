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

import android.app.Activity;
import android.view.View;

/**
 * Utility class for view
 *
 * author : Viking Den <vikingden@live.com>
 * time   : 2016/8/6 22:37
 */
public class ViewUtil {

    private ViewUtil(){
        throw new UnsupportedOperationException("must use static methods.") ;
    }

    /**
     * findViewById in activity
     * @param activity class of activity
     * @param resId resource id value for widget
     * @param <E> general type
     * @return view
     */
    public static <E extends View> E findViewById(Activity activity, int resId) {
        return (E) activity.findViewById(resId);
    }

    /**
     * findViewById in view
     * @param view class of ivew
     * @param resId resource id value for widget
     * @param <E> general type
     * @return view
     */
    public static <E extends View> E findViewById(View view, int resId) {
        return (E) view.findViewById(resId);
    }

}
