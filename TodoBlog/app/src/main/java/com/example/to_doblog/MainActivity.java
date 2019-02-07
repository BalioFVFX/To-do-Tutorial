package com.example.to_doblog;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ITask {

    private List<Task> tasks;
    private TaskAdapter taskAdapter;
    private TaskDialog taskDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.list_view);
        FloatingActionButton floatingActionButton = findViewById(R.id.fab_task);
        this.tasks = new ArrayList<>();
        this.taskAdapter = new TaskAdapter(getApplicationContext(), -1, tasks);
        this.taskDialog = new TaskDialog();
        this.taskDialog.setInterface(this);
        listView.setAdapter(taskAdapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskDialog.show(getSupportFragmentManager(), "0");
            }
        });
    }

    @Override
    public void showTask(String taskTitle) {
        Task task = new Task(taskTitle);
        tasks.add(task);
        this.taskAdapter.notifyDataSetChanged();
    }
}
