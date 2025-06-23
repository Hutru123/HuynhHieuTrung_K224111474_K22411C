package com.example.midtermapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.graphics.Insets;

import com.example.midtermapplication.adapter.TaskAdapter;
import com.example.midtermapplication.model.Task;

import java.util.ArrayList;
import java.util.List;

public class AdminTaskListActivity extends AppCompatActivity {

    ListView lvTasks;
    Button btnCreateNewTask;
    List<Task> taskList = new ArrayList<>();
    TaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_task_list);

        // Ensure padding for edge-to-edge (optional)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Ánh xạ view
        lvTasks = findViewById(R.id.lvTasks);
        btnCreateNewTask = findViewById(R.id.btnCreatenewtask);


        // Gán adapter
        adapter = new TaskAdapter(this, taskList);
        lvTasks.setAdapter(adapter);

        // Bắt sự kiện nút tạo task
        btnCreateNewTask.setOnClickListener(v -> {
            Intent intent = new Intent(AdminTaskListActivity.this, CreateTaskActivity.class);
            startActivity(intent);
        });
    }
}
