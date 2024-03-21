package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Medicine extends AppCompatActivity {

    private EditText editText_licenseNumber;
    private View editText_chineseName;
    private View editText_englishName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        // 初始化各個視圖元件
        TextView textView5 = findViewById(R.id.textView5);
        Spinner spinner_licenseNumber = findViewById(R.id.spinner_licenseNumber);
        editText_licenseNumber = findViewById(R.id.editText_licenseNumber);
        editText_chineseName = findViewById(R.id.editText_chineseName);
        editText_englishName = findViewById(R.id.editText_englishName);
        Spinner spinner_shape = findViewById(R.id.spinner_shape);
        Spinner spinner_notch = findViewById(R.id.spinner_notch);
        Spinner spinner_color = findViewById(R.id.spinner_color);
        Spinner spinner_symbol = findViewById(R.id.spinner_symbol);

        Spinner spinner_markings = findViewById(R.id.spinner_markings);

        // 設置許可證下拉式選單的項目
        ArrayAdapter<CharSequence> licenseAdapter = ArrayAdapter.createFromResource(this,
                R.array.license_numbers, android.R.layout.simple_spinner_item);
        licenseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_licenseNumber.setAdapter(licenseAdapter);

        // 設置形狀下拉式選單的項目
        ArrayAdapter<CharSequence> shapeAdapter = ArrayAdapter.createFromResource(this,
                R.array.shapes, android.R.layout.simple_spinner_item);
        shapeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_shape.setAdapter(shapeAdapter);

        // 設置刻痕下拉式選單的項目
        ArrayAdapter<CharSequence> notchAdapter = ArrayAdapter.createFromResource(this,
                R.array.notches, android.R.layout.simple_spinner_item);
        notchAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_notch.setAdapter(notchAdapter);

        // 設置顏色下拉式選單的項目
        ArrayAdapter<CharSequence> colorAdapter = ArrayAdapter.createFromResource(this,
                R.array.colors, android.R.layout.simple_spinner_item);
        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_color.setAdapter(colorAdapter);

        // 設置符號下拉式選單的項目
        ArrayAdapter<CharSequence> symbolAdapter = ArrayAdapter.createFromResource(this,
                R.array.symbols, android.R.layout.simple_spinner_item);
        symbolAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_symbol.setAdapter(symbolAdapter);

        // 設置標記下拉式選單的項目
        ArrayAdapter<CharSequence> markingsAdapter = ArrayAdapter.createFromResource(this,
                R.array.markings, android.R.layout.simple_spinner_item);
        markingsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_markings.setAdapter(markingsAdapter);
    }

    public EditText getEditText_licenseNumber() {
        return editText_licenseNumber;
    }

    public void setEditText_licenseNumber(EditText editText_licenseNumber) {
        this.editText_licenseNumber = editText_licenseNumber;
    }
}
