package com.alexey.shifu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mMainListView;
    private ListItemAdapter listItemAdapter;

    DBHelper mDBHelper = new DBHelper(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cursor cursor = mDBHelper.getWritableDatabase().rawQuery("SELECT * FROM " + DBHelper.TABLE_NAME, null);

        listItemAdapter = new ListItemAdapter(MainActivity.this, cursor);
        mMainListView = findViewById(R.id.mainListView);
        mMainListView.setAdapter(listItemAdapter);

        mDBHelper.add("First", "HAH");
        mDBHelper.add("Second", "ABC");
        mDBHelper.add("Third", "OOO");

        cursor.requery();

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
