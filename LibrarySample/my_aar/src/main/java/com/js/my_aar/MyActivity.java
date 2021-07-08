package com.js.my_aar;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MyActivity extends AppCompatActivity {
    private final static String TAG = MyActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, ">>> onCreate");
    }
}
