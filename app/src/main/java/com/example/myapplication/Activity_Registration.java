package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Registration extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText fullnameEditText;
    private EditText phoneEditText;
    private EditText emailEditText;
    private EditText homeEditText;
    private EditText birthdayEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // View Binding
        com.example.myapplication.databinding.ActivityRegistrationBinding binding
                = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 初始化 View 元件
        usernameEditText = binding.username;
        passwordEditText = binding.password;
        fullnameEditText = binding.fullname;
        phoneEditText = binding.phone;
        emailEditText = binding.email;
        homeEditText = binding.home;
        birthdayEditText = binding.birthday;
        Button registerButton = binding.registerButton;

        // 設置註冊按鈕點擊事件
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 獲取輸入的資料
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String fullname = fullnameEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String home = homeEditText.getText().toString();
                String birthday = birthdayEditText.getText().toString();

                // TODO: 在這裡執行註冊邏輯，這裡只是簡單地顯示一個提示
                String message = "使用者名稱: " + username +
                        "\n密碼: " + password +
                        "\n姓名: " + fullname +
                        "\n電話: " + phone +
                        "\n信箱: " + email +
                        "\n住址: " + home +
                        "\n生日: " + birthday;

                Toast.makeText(Activity_Registration.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}
