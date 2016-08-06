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
package com.viking.android_common_util;

import android.app.Instrumentation;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;

import com.viking.android_common.util.AppUtil;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * description
 * author : Viking Den <vikingden@live.com>
 * time   : 2016/8/6 16:02
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class AppUtilTest {

    private UiDevice mDevice ;
    private Instrumentation instrumentation ;
    private Context context ;

    private static final int DEFAULT_TIMEOUT = 10*1000 ;

    private static final String packagename = "com.google.android.youtube" ;
    private static final String fakePakcagename = "com.google.android.fakeyoutube" ;
    private static final String emptypackagename = "" ;

    @Before
    public void setUp() {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        instrumentation = InstrumentationRegistry.getInstrumentation() ;
        context = instrumentation.getContext() ;

        // Start from the home screen
        mDevice.pressHome();
        mDevice.pressHome();
        mDevice.pressHome();
    }

    @Test
    public void openAppByPackageName(){
        //open an exist application by package name

        Assert.assertTrue("open exist youtube application has failed.",AppUtil.openAppByPackageName(context ,packagename));
        mDevice.wait(Until.hasObject(By.pkg(packagename)) , DEFAULT_TIMEOUT) ;
        mDevice.pressHome() ;
        Assert.assertFalse("open not exist application has failed.",AppUtil.openAppByPackageName(context ,fakePakcagename));
        Assert.assertFalse("open empty application has failed.",AppUtil.openAppByPackageName(context ,emptypackagename));
    }

    @Test
    public void openAppInfoByPackageName(){
        //open an exist application by package name
        String packagename = "com.google.android.youtube" ;
        String fakePakcagename = "com.google.android.fakeyoutube" ;
        String emptypackagename = "" ;
        Assert.assertTrue("open exist youtube application has failed.",AppUtil.openAppInfoByPackageName(context ,packagename));
        mDevice.wait(Until.hasObject(By.text("YouTube")) , DEFAULT_TIMEOUT) ;
        mDevice.pressHome() ;
        Assert.assertFalse("open not exist application has failed.",AppUtil.openAppInfoByPackageName(context ,fakePakcagename));
        Assert.assertFalse("open empty application has failed.",AppUtil.openAppInfoByPackageName(context ,emptypackagename));
    }
}
