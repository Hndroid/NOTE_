package com.example.learnhotfix;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "Activity.class 由：" + Activity.class.getClassLoader() + " 加载");
        Log.e(TAG, "MainActivity.class 由：" + MainActivity.class.getClassLoader() + " 加载");
    }
}
