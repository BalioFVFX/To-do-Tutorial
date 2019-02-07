package com.example.to_doblog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TaskDialog extends DialogFragment {

    private Button saveButton;
    private Button cancelButton;
    private EditText taskTitleEditText;
    private ITask iTask;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        //
        View dialogView = layoutInflater.inflate(R.layout.dialog_task, null);
        this.initViews(dialogView);
        this.initListeners();
        builder.setView(dialogView);

        return builder.create();
    }

    public void setInterface(ITask iTask) {
        this.iTask = iTask;
    }

    private void initViews(View view) {
        this.saveButton = view.findViewById(R.id.btn_save);
        this.cancelButton = view.findViewById(R.id.btn_cancel);
        this.taskTitleEditText = view.findViewById(R.id.et_task_title);
    }

    private void initListeners() {
        this.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iTask.showTask(taskTitleEditText.getText().toString());
                taskTitleEditText.setText("");
                dismiss();
            }
        });

        this.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskTitleEditText.setText("");
                dismiss();
            }
        });
    }
}
