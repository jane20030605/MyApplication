package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityCalenderThingBinding;

import java.util.HashSet;
import java.util.Set;

public class Activity_Calender_thing extends AppCompatActivity {

    private ActivityCalenderThingBinding binding; // View Binding
    String[] companionsList = {"家人", "朋友", "個人", "工作"};
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalenderThingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 初始化 SharedPreferences
        sharedPreferences = getSharedPreferences("MyCalendar", Context.MODE_PRIVATE);

        // 加載保存的陪同人員列表
        Set<String> companionsSet = sharedPreferences.getStringSet("companionsList", null);
        if (companionsSet != null) {
            companionsList = companionsSet.toArray(new String[0]);
        }

        // 設置日期和時間的 Spinner Adapter
        setupDateSpinner();
        setupTimeSpinner();

        // 創建陪同人員的 Spinner Adapter
        ArrayAdapter<String> companionsAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_item, companionsList);

        // 設置 Spinner Adapter
        binding.spinnerCompanions.setAdapter(companionsAdapter);

        // 保存事件按鈕點擊事件
        binding.button3.setOnClickListener(view -> {
            // 獲取選擇的日期
            @SuppressLint("DefaultLocale") String selectedStartDate = String.format("%04d/%02d/%02d",
                    binding.datePickerStartDate.getYear(),
                    binding.datePickerStartDate.getMonth() + 1,
                    binding.datePickerStartDate.getDayOfMonth());
            @SuppressLint("DefaultLocale") String selectedEndDate = String.format("%04d/%02d/%02d",
                    binding.datePickerEndDate.getYear(),
                    binding.datePickerEndDate.getMonth() + 1,
                    binding.datePickerEndDate.getDayOfMonth());

            // 獲取選擇的時間
            @SuppressLint("DefaultLocale") String selectedStartTime = String.format("%02d:%02d",
                    binding.timePickerStartTime.getHour(),
                    binding.timePickerStartTime.getMinute());
            @SuppressLint("DefaultLocale") String selectedEndTime = String.format("%02d:%02d",
                    binding.timePickerEndTime.getHour(),
                    binding.timePickerEndTime.getMinute());

            // 獲取事件對象輸入
            String companions = binding.spinnerCompanions.getSelectedItem().toString();

            // 獲取事件說明輸入
            String eventDescription = binding.editTextEventDescription.getText().toString();

            // 保存事件到 SharedPreferences
            saveEvent(selectedStartDate, selectedEndDate, selectedStartTime, selectedEndTime, companions, eventDescription);

            // 顯示 Toast 提示
            String toastMessage =
                    "事件已保存：" +
                            "\n起始日期：" + selectedStartDate +
                            "\n結束日期：" + selectedEndDate +
                            "\n起始時間：" + selectedStartTime +
                            "\n結束時間：" + selectedEndTime +
                            "\n事件對象：" + companions +
                            "\n事件說明：" + eventDescription;

            Toast.makeText(Activity_Calender_thing.this, toastMessage, Toast.LENGTH_LONG).show();
            // 返回到Activity_Calender页面
            Intent intent = new Intent(Activity_Calender_thing.this, Activity_Calender.class);
            startActivity(intent);
            finish(); // 結束当前Activity
        });
    }

    // 設置日期的 Spinner Adapter
    private void setupDateSpinner() {
        // 不需要設置 Spinner Adapter，因為已經使用 DatePicker 來選擇日期
    }

    // 設置時間的 Spinner Adapter
    private void setupTimeSpinner() {
        // 不需要設置 Spinner Adapter，因為已經使用 TimePicker 來選擇時間
    }

    // 保存事件到 SharedPreferences
    @SuppressLint({"ApplySharedPref", "MutatingSharedPrefs"})
    private void saveEvent(String startDate, String endDate, String startTime, String endTime, String companions, String description) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // 構建事件字串
        String eventString = startDate + ";" + endDate + ";" + startTime + ";" + endTime + ";" + companions + ";" + description;
        // 從 SharedPreferences 中獲取已有事件列表
        Set<String> eventsSet = sharedPreferences.getStringSet("events", new HashSet<>());
        // 將新事件添加到列表中
        eventsSet.add(eventString);
        // 保存更新後的事件列表到 SharedPreferences
        editor.putStringSet("events", eventsSet);
        editor.commit(); // 使用 commit() 而不是 apply()，以確保立即寫入
    }
}
