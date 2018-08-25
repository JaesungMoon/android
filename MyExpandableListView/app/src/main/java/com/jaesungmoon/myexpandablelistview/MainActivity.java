package com.jaesungmoon.myexpandablelistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ExpandableListView expandableListView = findViewById(R.id.expandable_list_view);
//        MyExpandableListAdapter adapter = new MyExpandableListAdapter();
//        expandableListView.setAdapter(adapter);
startActivity(new Intent(this, MyExpandableListAdapter.class));
    }
}
