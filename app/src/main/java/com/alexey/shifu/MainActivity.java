package com.alexey.shifu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListItemAdapter listItemAdapter;
    ListView mMainListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listItemAdapter = new ListItemAdapter(MainActivity.this, R.layout.main_list_item, DB.firstValues);
        mMainListView = findViewById(R.id.mainListView);
        mMainListView.setAdapter(listItemAdapter);

        DB.add("First", "first string");
        DB.add("Second", "second string");
        DB.add("Third", "third string");
    }
}
