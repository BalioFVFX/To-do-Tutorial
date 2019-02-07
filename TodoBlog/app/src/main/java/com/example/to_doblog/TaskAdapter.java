package com.example.to_doblog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class TaskAdapter extends ArrayAdapter<Task> {
    private Context context;
    private List<Task> tasks;

    public TaskAdapter(Context context, int resource, List<Task> tasks) {
        super(context, resource);
        this.tasks = tasks;
        this.context = context;
    }

    @Override
    public Task getItem(int position) {
        return this.tasks.get(position);
    }

    @Override
    public int getCount() {
        return this.tasks.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_task, null);
        }

        TextView taskTitle = view.findViewById(R.id.tv_task_title);

        taskTitle.setText(getItem(position).getTitle());

        return view;
    }
}