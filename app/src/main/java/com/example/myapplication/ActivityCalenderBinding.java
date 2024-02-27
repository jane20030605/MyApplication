package com.example.myapplication;

import android.view.LayoutInflater;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ActivityCalenderBinding {
    public DatePicker datePicker;
    public FloatingActionButton fabAddEvent;
    public TextView eventTextView;

    public static ActivityCalenderBinding inflate(LayoutInflater layoutInflater) {
        return null;
    }

    public int getRoot() {
        return 0;
    }
}
