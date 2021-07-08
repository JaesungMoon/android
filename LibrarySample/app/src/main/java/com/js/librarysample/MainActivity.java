package com.js.librarysample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.js.my_aar.MyActivity;
import com.js.my_pure_aar.MyPureAar;

public class MainActivity extends MyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyPureAar pureAar = new MyPureAar();
        pureAar.printLog();
    }
}