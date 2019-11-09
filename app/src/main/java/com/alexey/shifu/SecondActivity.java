package com.alexey.shifu;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView mTitleTextView;
    private TextView mTextTextView;

    DBHelper mDBHelper = new DBHelper(SecondActivity.this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mTitleTextView = findViewById(R.id.title);
        mTextTextView = findViewById(R.id.text);

        long id = (long) getIntent().getExtras().get("id");

        Cursor cursor = mDBHelper.getWritableDatabase().query(DBHelper.TABLE_NAME, null,
                "_id = ?", new String[] {id+""},
                null,null, null);


        mTitleTextView.setText(mDBHelper.getFirstValue((int)id));
        mTextTextView.setText(mDBHelper.getSecondValue((int)id));
    }
}
