package com.js.librarysample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.js.my_aar.MyActivity;

public class MainActivity extends MyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}