package com.example.midtermapplication.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.midtermapplication.model.Task;

import java.util.List;


public class TaskAdapter extends ArrayAdapter<Task> {

    public TaskAdapter(Context context, List<Task> tasks) {
        super(context, 0, tasks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Task task = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);

        TextView title = convertView.findViewById(android.R.id.text1);
        TextView description = convertView.findViewById(android.R.id.text2);

        title.setText(task.title);
        description.setText(task.description);

        convertView.setBackgroundColor(task.isCompleted ? Color.parseColor("#C8E6C9") : Color.parseColor("#FFF9C4"));
        return convertView;
    }
}