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
package com.viking.android_common.log.annotation;

import android.support.annotation.NonNull;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Provide configuration elements to the
 * {@link com.viking.android_common.log.VLog#init(android.app.Application)} method.
 * author : Viking Den <vikingden@live.com>
 * time   : 2016/10/31 20:50
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface VLogAnnotation {

    /**
     * setup VLog's tag
     * @return log's tag value
     */
    @NonNull String logTag() default "VLog" ;

    /**
     *
     * @return Weather to print the log or not
     */
    boolean enablePrintLog() default false ;
}
