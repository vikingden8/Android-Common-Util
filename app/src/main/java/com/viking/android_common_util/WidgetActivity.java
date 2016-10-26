package com.viking.android_common_util;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WidgetActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView mListView ;

    private String[] items = new String[]{
            "Widget"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_widget);
        mListView = (ListView) findViewById(R.id.widget_list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this , android.R.layout.simple_expandable_list_item_1 , items) ;
        mListView.setAdapter(arrayAdapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                startActivity(new Intent(this , SimpleWidgetActivity.class));
                break ;
        }
    }
}
