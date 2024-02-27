package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import com.example.myapplication.databinding.ActivityUserSetBinding;

public class Activity_user_set extends AppCompatActivity {

    private ActivityUserSetBinding binding; // View Binding
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserSetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); // 设置Toolbar为ActionBar
        getSupportActionBar().hide(); // 禁用ActionBar

        // 初始化 Spinner 的資料
        initSpinner();

        // 設置 Switch 的監聽事件
        binding.notificationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                showToast("通知提醒：" + (isChecked ? "啟用" : "停用"));
                // 在這裡添加處理通知提醒 Switch 狀態改變的邏輯
            }
        });

        // 設置 RadioGroup 的監聽事件
        binding.themeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.dayModeRadio) {
                    showToast("選擇了日間模式");
                    // 切換為日間模式
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else if (checkedId == R.id.nightModeRadio) {
                    showToast("選擇了夜間模式");
                    // 切換為夜間模式
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                recreate(); // 重新建立 Activity 以應用主題更改
            }
        });

        // 設置 Button 的點擊事件
        binding.feedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("點擊了用戶反饋按鈕");
                // 在這裡添加處理用戶反饋按鈕點擊的邏輯
                Intent main = new Intent(Activity_user_set.this, Activity_user_set_back.class);
                startActivity(main);
            }
        });

        binding.guidedTourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("點擊了新手指引按鈕");
                // 在這裡添加處理新手指引按鈕點擊的邏輯
                Intent main = new Intent(Activity_user_set.this, Activity_user_set_new.class);
                startActivity(main);
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void initSpinner() {
        // 取得 Spinner
        Spinner themeColorSpinner = binding.themeColorSpinner;
        Spinner stringLanguageSpinner = binding.stringLanguage2;

        // 定義 Spinner 的資料
        String[] themeColorArray = {"Red", "Green", "Blue","pink","yellow"};
        String[] languageArray = {"English", "中文", "Español"};

        // 建立 ArrayAdapter 並設置資料
        ArrayAdapter<String> themeColorAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, themeColorArray);
        ArrayAdapter<String> languageAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, languageArray);

        // 設置下拉選單的樣式
        themeColorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // 設置 Adapter 到 Spinner
        themeColorSpinner.setAdapter(themeColorAdapter);
        stringLanguageSpinner.setAdapter(languageAdapter);

        // 設置 Spinner 的選擇事件
        themeColorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                showToast("選擇主題顏色：" + themeColorArray[position]);
                // 在這裡添加處理主題顏色選擇的邏輯
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Do nothing
            }
        });

        stringLanguageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                showToast("選擇語言：" + languageArray[position]);
                // 在這裡添加處理語言選擇的邏輯
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Do nothing
            }
        });
    }
}
