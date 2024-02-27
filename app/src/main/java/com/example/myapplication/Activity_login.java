package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public class Activity_login extends AppCompatActivity {

    private LoginViewModel viewModel;
    private Button Button11;
    private Button Button12;
    private Button Button13;
    private Button Button14;

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
        Button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 登入按鈕點擊事件
                String username = viewModel.getUsername();
                String password = viewModel.getPassword();

                // 在這裡實現登入邏輯，可以使用 username 和 password
                // 示範一下顯示一個 Toast 訊息
                Toast.makeText(Activity_login.this, "登入: " + username, Toast.LENGTH_SHORT).show();
            }
        });

        Button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 註冊按鈕點擊事件
                String username = viewModel.getUsername();
                String password = viewModel.getPassword();

                Intent main = new Intent(Activity_login.this, Activity_Registration.class);
                startActivity(main);
            }
        });

        Button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 指紋辨識按鈕點擊事件
                // 在這裡實現指紋辨識邏輯
                Toast.makeText(Activity_login.this, "指紋辨識", Toast.LENGTH_SHORT).show();
            }
        });
        Button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Google 帳戶聯動按鈕點擊事件
                // 在這裡實現 Google 帳戶聯動邏輯
                Toast.makeText(Activity_login.this, "Google 帳戶聯動", Toast.LENGTH_SHORT).show();

            }
        });
    }
}