package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityCalenderBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashSet;
import java.util.Set;
public class Activity_Calender extends AppCompatActivity {

    private TextView eventTextView;
    private int selectedYear;
    private int selectedMonth;
    private int selectedDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCalenderBinding binding = ActivityCalenderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 取得 FloatingActionButton
        FloatingActionButton fabAddEvent = binding.fabAddEvent;

        // 初始化事件文本視圖
        eventTextView = binding.eventTextView;

        // 找到日期選擇器，並添加一個選擇日期的監聽器
        DatePicker datePicker = binding.datePicker;
        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), (view, year, monthOfYear, dayOfMonth) -> {
            // 在日期選擇改變時，更新圓形事件新增按鈕中的日期文本
            selectedYear = year;
            selectedMonth = monthOfYear;
            selectedDay = dayOfMonth;
            updateAddEventButtonDate(fabAddEvent);
        });

        // 設定 FloatingActionButton 點擊事件
        fabAddEvent.setOnClickListener(view -> {
            // 處理 FloatingActionButton 點擊事件
            try {
                openAddEventActivity();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(Activity_Calender.this, "Error occurred", Toast.LENGTH_SHORT).show();
            }
        });

        // 在onCreate中呼叫方法來顯示事件
        displayEvents();
    }

    // 添加一個方法來更新圓形事件新增按鈕中的日期文本
    private void updateAddEventButtonDate(FloatingActionButton fabAddEvent) {
        // 根據選擇的日期更新新增按鈕中的日期文本
        @SuppressLint("DefaultLocale") String selectedDateText = String.format("%d/%02d/%02d", selectedYear, selectedMonth + 1, selectedDay);
        fabAddEvent.setTextDirection(Integer.parseInt(selectedDateText));
    }

    // 打開新增事件的活動
    private void openAddEventActivity() {
        Intent intent = new Intent(this, Activity_Calender_thing.class);
        // 將所選日期作為意圖的一部分傳遞給下一個活動
        intent.putExtra("selectedYear", selectedYear);
        intent.putExtra("selectedMonth", selectedMonth);
        intent.putExtra("selectedDay", selectedDay);
        startActivity(intent);
    }

    // 在行事曆介面上顯示事件的方法
    private void displayEvents() {
        // 從 SharedPreferences 中讀取已保存的事件
        SharedPreferences sharedPreferences = getSharedPreferences("MyCalendar", MODE_PRIVATE);
        Set<String> eventsSet = sharedPreferences.getStringSet("events", new HashSet<>());

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

            eventsText.append("起始日期: ").append(startDate).append("\n")
                    .append("結束日期: ").append(endDate).append("\n")
                    .append("起始時間: ").append(startTime).append("\n")
                    .append("結束時間: ").append(endTime).append("\n")
                    .append("事件對象: ").append(companions).append("\n")
                    .append("事件說明: ").append(description).append("\n\n");

            // 添加編輯按鈕
            eventsText.append("\n");
        }

        // 將格式化後的事件文本設置到事件文本視圖中
        eventTextView.setText(eventsText.toString());
    }

}
