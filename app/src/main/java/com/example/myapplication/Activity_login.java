package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public class Activity_login extends AppCompatActivity {

    private LoginViewModel viewModel;
    private final Button Button11;
    private final Button Button12;
    private final Button Button13;
    private final Button Button14;

    public Activity_login(Button button11, Button button12, Button button13, Button button14) {
        Button11 = button11;
        Button12 = button12;
        Button13 = button13;
        Button14 = button14;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewDataBinding binding = DataBindingUtil.setContentView
                (this, R.layout.activity_login);
        setContentView(binding.getRoot());

        viewModel = new LoginViewModel();
        buttonSetting();  // 設置按鈕點擊事件

        binding.setLifecycleOwner(this);
    }


    private void buttonSetting() {
        // 使用binding對象直接設置按鈕點擊事件
        Button11.setOnClickListener(view -> {
            // 登入按鈕點擊事件
            String username = viewModel.getUsername();
            viewModel.getPassword();

            // 在這裡實現登入邏輯，可以使用 username 和 password
            // 示範一下顯示一個 Toast 訊息
            Toast.makeText(Activity_login.this, "登入: " + username, Toast.LENGTH_SHORT).show();
        });

        Button12.setOnClickListener(view -> {
            // 註冊按鈕點擊事件
            viewModel.getUsername();
            viewModel.getPassword();

            Intent main = new Intent(Activity_login.this, Activity_Registration.class);
            startActivity(main);
        });

        Button14.setOnClickListener(view -> {
            // Google 帳戶聯動按鈕點擊事件
            // 在這裡實現 Google 帳戶聯動邏輯
            Toast.makeText(Activity_login.this, "Google 帳戶聯動", Toast.LENGTH_SHORT).show();

        });
    }
}