package com.example.todolistyoutube;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.todolistyoutube.model.Task;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
implements ITask{

    private List<Task> tasks;
    private ListView listView;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tasks = new ArrayList<>();
        this.listView = this.findViewById(R.id.list_view);
        FloatingActionButton floatingActionButton = this.findViewById(R.id.fab_task);
        this.taskAdapter = new TaskAdapter(getApplicationContext(), R.layout.tasks_layout, tasks);
        listView.setAdapter(taskAdapter);
        final TaskDialog taskDialog = new TaskDialog();
        taskDialog.setInterface(this);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskDialog.show(getSupportFragmentManager(), "0");
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tasks.remove(position);
                taskAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Task removed", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void addTask(String name, String description) {
        this.tasks.add(new Task(name, description));
        this.taskAdapter.notifyDataSetChanged();
    }
}
