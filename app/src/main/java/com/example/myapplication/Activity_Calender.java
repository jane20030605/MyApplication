package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityCalenderBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashSet;
import java.util.Set;

public class Activity_Calender extends AppCompatActivity {

    private ActivityCalenderBinding binding;
    private TextView eventTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalenderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 取得 DatePicker
        DatePicker datePicker = binding.datePicker;

        // 取得 FloatingActionButton
        FloatingActionButton fabAddEvent = binding.fabAddEvent;

        // 初始化事件文本視圖
        eventTextView = binding.eventTextView;

        // 設定 FloatingActionButton 點擊事件
        fabAddEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 處理 FloatingActionButton 點擊事件
                try {
                    openAddEventActivity();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(Activity_Calender.this, "發生錯誤", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 在onCreate中呼叫方法來顯示事件
        displayEvents();
    }

    // 打開新增事件的活動
    private void openAddEventActivity() {
        Intent intent = new Intent(this, Activity_Calender_thing.class);
        startActivity(intent);
    }

    // 在行事曆介面上顯示事件的方法
    private void displayEvents() {
        // 從 SharedPreferences 中讀取已保存的事件
        SharedPreferences sharedPreferences = getSharedPreferences("MyCalendar", MODE_PRIVATE);
        Set<String> eventsSet = sharedPreferences.getStringSet("events", new HashSet<String>());

        // 將事件格式化並顯示在事件文本視圖中
        StringBuilder eventsText = new StringBuilder();
        for (String event : eventsSet) {
            String[] eventDetails = event.split(";");
            String startDate = eventDetails[0];
            String endDate = eventDetails[1];
            String startTime = eventDetails[2];
            String endTime = eventDetails[3];
            String companions = eventDetails[4];
            String description = eventDetails[5];

            eventsText.append("起始日期：").append(startDate).append("\n")
                    .append("結束日期：").append(endDate).append("\n")
                    .append("起始時間：").append(startTime).append("\n")
                    .append("結束時間：").append(endTime).append("\n")
                    .append("事件對象：").append(companions).append("\n")
                    .append("事件說明：").append(description).append("\n\n");
        }

        // 將格式化後的事件文本設置到事件文本視圖中
        eventTextView.setText(eventsText.toString());
    }
}
