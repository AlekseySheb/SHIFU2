package com.alexey.shifu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListItemAdapter listItemAdapter;
    private ListView mMainListView;

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

        mMainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }
}
