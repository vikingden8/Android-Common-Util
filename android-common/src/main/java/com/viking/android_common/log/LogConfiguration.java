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

import android.text.TextUtils;

/**
 * description
 * author : Viking Den <vikingden@live.com>
 * time   : 2016/10/27 22:02
 */
public final class LogConfiguration {

    private String logTag ;

    private boolean enableLogPrint ;

    private boolean isLogTagEmpty = true ;

    public LogConfiguration(LogConfigurationBuilder builder){
        this.logTag = builder.logTag ;
        this.enableLogPrint = builder.enableLogPrint ;
        this.isLogTagEmpty = TextUtils.isEmpty(logTag) ;
    }

    public String getLogTag(){
        return this.logTag ;
    }

    public boolean enableLogPrint(){
        return this.enableLogPrint ;
    }

    public boolean isLogTagEmpty(){
        return this.isLogTagEmpty ;
    }
}
