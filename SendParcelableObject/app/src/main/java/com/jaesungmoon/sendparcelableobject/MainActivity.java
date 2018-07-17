package com.jaesungmoon.sendparcelableobject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

private RecyclerView mRecyclerView;
private LinearLayoutManager mLayoutManager;
private ExampleAdapter mExampleAdapter;
private ArrayList<ExampleItem> mExampleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        buildRecyclerView();
    }
    private void createExampleList() {
        mExampleList = new ArrayList<>();

    }
    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mExampleAdapter = new ExampleAdapter(mExampleList);
        mRecyclerView.setAdapter(mExampleAdapter);
    }
}
