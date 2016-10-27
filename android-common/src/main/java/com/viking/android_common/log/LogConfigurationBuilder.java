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
 * description
 * author : Viking Den <vikingden@live.com>
 * time   : 2016/10/27 22:00
 */
public final class LogConfigurationBuilder {

    String logTag ;

    boolean enableLogPrint = true;

    public LogConfigurationBuilder(@NonNull Application application){

    }

    public LogConfiguration build(){
        return new LogConfiguration(this) ;
    }

    public LogConfigurationBuilder setLogTag(String tag){
        this.logTag = tag ;
        return this ;
    }

    public LogConfigurationBuilder enableLogPrint(boolean enableLogPrint){
        this.enableLogPrint = enableLogPrint ;
        return this ;
    }

}
