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
import android.support.test.uiautomator.UiDevice;

import com.viking.android_common.util.DeviceUtil;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * test for DeviceUtil class
 * author : Viking Den <vikingden@live.com>
 * time   : 2016/8/6 18:44
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class DeviceUtilTest {

    private UiDevice mDevice ;
    private Instrumentation instrumentation ;
    private Context context ;

    private static final int DEFAULT_TIMEOUT = 10*1000 ;

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
    public void getMacAddress() throws Exception{
        String macAddress = DeviceUtil.getMacAddress(context) ;
        DeviceUtil.useJavaInterface();
        System.out.println("viking macaddress : " + macAddress) ;
        Assert.assertTrue("can not get mac address" , !macAddress.equals(""));
    }

    @Test
    public void getManufacturer(){
        String manufacturer = DeviceUtil.getManufacturer() ;
        System.out.println("viking manufacturer : " + manufacturer) ;
        Assert.assertTrue("can not get manufacturer" , !manufacturer.equals(""));
    }

    @Test
    public void getModel(){
        String model = DeviceUtil.getModel() ;
        System.out.println("viking model : " + model) ;
        Assert.assertTrue("can not get model" , !model.equals(""));
    }
}
