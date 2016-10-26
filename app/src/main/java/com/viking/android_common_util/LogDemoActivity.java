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

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.viking.android_common.log.VLog;

/**
 * Demo for show how to use VLog
 * author : Viking Den <vikingden@live.com>
 * time   : 2016/10/26 23:06
 */
public class LogDemoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView mListView;

    private String[] items = new String[]{
            "Log.v",
            "Log.d",
            "Log.i",
            "Log.w",
            "Log.e",
            "Log.wtf"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListView = new ListView(this) ;
        VLog.init(true , "LogDemo");
        setContentView(mListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_expandable_list_item_1, items);
        mListView.setAdapter(arrayAdapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                VLog.v("VLog.v");
                break;
            case 1:
                VLog.d("VLog.d");
                break ;
            case 2:
                VLog.i("VLog.i");
                break ;
            case 3:
                VLog.w("VLog.w");
                break ;
            case 4:
                VLog.e("LogDemo","VLog.e","VLog.e");
                break;
            case 5:
                VLog.wtf("VLog.wtf");
                break ;
        }
    }
}
