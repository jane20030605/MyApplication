package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityUserBinding;

public class Activity_User extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // View Binding
        com.example.myapplication.databinding.ActivityUserBinding binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 使用 View Binding 取代 findViewById
        Button profileButton = binding.profileButton;
        Button favoritesButton = binding.favoritesButton;
        Button activityButton = binding.activityButton;
        Button settingsButton = binding.settingsButton;

        // 設置按鈕點擊事件
        profileButton.setOnClickListener(view -> {
            showToast("點擊了個人檔案按鈕");
            // 在這裡添加處理個人檔案按鈕點擊的邏輯
            Intent main = new Intent(Activity_User.this, Activity_user_data.class);
            startActivity(main);
        });

        favoritesButton.setOnClickListener(view -> {
            showToast("點擊了最愛收藏按鈕");
            // 在這裡添加處理最愛收藏按鈕點擊的邏輯
            Intent main = new Intent(Activity_User.this, Activity_user_like.class);
            startActivity(main);
        });

        activityButton.setOnClickListener(view -> {
            showToast("點擊了活動紀錄按鈕");
            // 在這裡添加處理活動紀錄按鈕點擊的邏輯
            Intent main = new Intent(Activity_User.this, Activity_user_memory.class);
            startActivity(main);
        });

        settingsButton.setOnClickListener(view -> {
            showToast("點擊了系統設定按鈕");
            // 在這裡添加處理系統設定按鈕點擊的邏輯
            Intent main = new Intent(Activity_User.this, Activity_user_set.class);
            startActivity(main);
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
