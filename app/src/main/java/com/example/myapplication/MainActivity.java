package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private Button radioButton;
    private Button radioButton2;
    private Button radioButton3;
    private Button radioButton4;
    private Button radioButton5;
    private Button radioButton6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(view ->
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        init();  // 初始化按鈕
        buttonSetting();  // 設置按鈕點擊事件

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // 設置頂級目的地 ID
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();

        // 設置 NavController 和 DrawerLayout 的聯動
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    // 用函式:init去初始化button的位置(利用binding取代findViewById)
    private void init() {
        // 使用 binding 對象直接初始化按鈕
        radioButton = binding.radioButton1;
        radioButton2 = binding.radioButton2;
        radioButton3 = binding.radioButton3;
        radioButton4 = binding.radioButton4;
        radioButton5 = binding.radioButton5;
        radioButton6 = binding.radioButton6;
    }

    private void buttonSetting() {
        // 使用binding對象直接設置按鈕點擊事件
        radioButton.setOnClickListener(view -> {
            Intent main = new Intent(MainActivity.this, Activity_login.class);
            startActivity(main);
        });

        radioButton2.setOnClickListener(view -> {
            Intent main = new Intent(MainActivity.this, Activity_Medicine_box.class);
            startActivity(main);
        });

        radioButton3.setOnClickListener(view -> {
            Intent main = new Intent(MainActivity.this, Activity_Medicine.class);
            startActivity(main);
        });

        radioButton4.setOnClickListener(view -> {
            Intent main = new Intent(MainActivity.this, Activity_Memory.class);
            startActivity(main);
        });

        radioButton5.setOnClickListener(view -> {
            Intent main = new Intent(MainActivity.this, Activity_Calender.class);
            startActivity(main);
        });

        radioButton6.setOnClickListener(view -> {
            Intent main = new Intent(MainActivity.this,Activity_User.class);
            startActivity(main);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
