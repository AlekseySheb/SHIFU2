package com.alexey.shifu;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListItemAdapter extends ArrayAdapter<String> {
    public ListItemAdapter(@NonNull Context context, int resource, List<String> stringList) {
        super(context, resource, stringList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.main_list_item, parent, false);
        }

        TextView itemText = convertView.findViewById(R.id.itemText);

        String string = getItem(position);

        itemText.setText(string);

        return convertView;
    }
}
