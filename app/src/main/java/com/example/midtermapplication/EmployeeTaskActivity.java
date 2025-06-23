package com.example.midtermapplication;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.midtermapplication.adapter.TaskAdapter;
import com.example.midtermapplication.model.Task;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTaskActivity extends AppCompatActivity {

    ListView lvTasks;
    List<Task> taskList = new ArrayList<>();
    TaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_task);

        lvTasks = findViewById(R.id.lvTasks);

        // Dữ liệu mẫu (có thể thay bằng SQLite hoặc Intent gửi từ Login)
        taskList.add(new Task("Gọi khách hàng", "Gọi khách hàng A để xác nhận đơn", false));
        taskList.add(new Task("Kiểm kho", "Kiểm tra kho tại chi nhánh 2", true));
        taskList.add(new Task("Báo cáo", "Viết báo cáo tuần", false));

        // Tạo adapter và gán vào ListView
        adapter = new TaskAdapter(this, taskList);
        lvTasks.setAdapter(adapter);
    }
}