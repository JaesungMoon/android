package com.js.billing.libraryex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.js.billing.mylibrary.MyBilling;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyBilling myBilling = new MyBilling(this);

    }
}