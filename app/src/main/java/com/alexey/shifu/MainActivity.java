package com.alexey.shifu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListItemAdapter listItemAdapter;
    ListView mMainListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> stringList = new ArrayList<>();
        stringList.add("first");
        stringList.add("second");
        stringList.add("third");

        listItemAdapter = new ListItemAdapter(MainActivity.this, R.layout.main_list_item, stringList);
        mMainListView = findViewById(R.id.mainListView);

        mMainListView.setAdapter(listItemAdapter);

    }
}
