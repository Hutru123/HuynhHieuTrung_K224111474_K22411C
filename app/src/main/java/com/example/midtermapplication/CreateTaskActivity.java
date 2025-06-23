package com.example.midtermapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.midtermapplication.model.Task;

import java.util.ArrayList;
import java.util.List;

public class CreateTaskActivity extends AppCompatActivity {

    EditText edtTaskTitle;
    ListView lvAccount;
    Button btnCreateTask;

    List<String> accountList = new ArrayList<>();
    ArrayAdapter<String> accountAdapter;

    String selectedAccount = null; // lưu tài khoản được chọn

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        edtTaskTitle = findViewById(R.id.edtTasktile);
        lvAccount = findViewById(R.id.lvAccount);
        btnCreateTask = findViewById(R.id.btnCreateTask);



        accountAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, accountList);
        lvAccount.setAdapter(accountAdapter);
        lvAccount.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        // Khi chọn 1 người để giao task
        lvAccount.setOnItemClickListener((parent, view, position, id) -> {
            selectedAccount = accountList.get(position);
        });

        btnCreateTask.setOnClickListener(v -> {
            String title = edtTaskTitle.getText().toString().trim();

            if (title.isEmpty() || selectedAccount == null) {
                Toast.makeText(this, "Please enter title and select assignee", Toast.LENGTH_SHORT).show();
                return;
            }

            // Tạo Task mới
            Task newTask = new Task(title, "Assigned to: " + selectedAccount, false);

            // Trả về kết quả cho AdminTaskListActivity
            Intent resultIntent = new Intent();
            resultIntent.putExtra("taskTitle", newTask.title);
            resultIntent.putExtra("taskDesc", newTask.description);
            resultIntent.putExtra("taskCompleted", newTask.isCompleted);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}