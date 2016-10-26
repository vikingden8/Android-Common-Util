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
package com.viking.android_common.views;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.viking.android_common.R;

/**
 * TODO un-finished
 * Create an awesome About Page for your Android App<br>
 * author : Viking Den<br>
 * time   : 2016/7/23 09:49<br>
 * email  : vikingden@live.com<br>
 */
public class About {

    private final Context mContext;
    private final LayoutInflater mInflater;
    private final View mView;
    private String mDescription;
    private int mImage = 0;
    private boolean mIsRTL = false;
    private Typeface mCustomFont;

    public About(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mView = mInflater.inflate(R.layout.layout_about, null);
    }

    public About setCustomFont(String path) {
        mCustomFont = Typeface.createFromAsset(mContext.getAssets(), path);
        return this;
    }

    public About setImage(int resource) {
        this.mImage = resource;
        return this;
    }

    public About isRTL(boolean value) {
        this.mIsRTL = value;
        return this;
    }

    public About setDescription(String description) {
        this.mDescription = description;
        return this;
    }

    public About setDescription(int resid){
        this.mDescription = mContext.getString(resid) ;
        return this;
    }

    public View create() {
        TextView description = (TextView) mView.findViewById(R.id.description);
        ImageView image = (ImageView) mView.findViewById(R.id.image);
        if (mImage > 0) {
            image.setImageResource(mImage);
        }

        if (!TextUtils.isEmpty(mDescription)) {
            description.setText(mDescription);
        }

        description.setGravity(Gravity.CENTER);

        if (mCustomFont != null) {
            description.setTypeface(mCustomFont);
        }

        return mView;
    }

    private View getSeparator() {
        return mInflater.inflate(R.layout.layout_about_separator, null);
    }
}
