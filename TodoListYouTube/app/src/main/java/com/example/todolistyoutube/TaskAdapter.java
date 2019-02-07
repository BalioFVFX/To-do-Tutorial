package com.example.todolistyoutube;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.todolistyoutube.model.Task;

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
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.tasks_layout, null);
        }

        ImageView taskImage = view.findViewById(R.id.iv_task);
        TextView taskTitle = view.findViewById(R.id.tv_name);
        TextView taskDescription = view.findViewById(R.id.tv_description);

        taskTitle.setText(getItem(position).getName());
        taskDescription.setText(getItem(position).getDescription());

        return view;
    }


}
