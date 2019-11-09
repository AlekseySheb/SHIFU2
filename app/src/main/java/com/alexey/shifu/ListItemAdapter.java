package com.alexey.shifu;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ListItemAdapter extends CursorAdapter {
    public ListItemAdapter(@NonNull Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.main_list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView textView = view.findViewById(R.id.itemText);
        String text = cursor.getString(cursor.getColumnIndexOrThrow("FIRST_VOLUMES"));
        textView.setText(text);
    }
}
