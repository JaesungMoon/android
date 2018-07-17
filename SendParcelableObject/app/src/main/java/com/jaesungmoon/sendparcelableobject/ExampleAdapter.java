package com.jaesungmoon.sendparcelableobject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public ExampleViewHolder(View itemView) {
            super(itemView);
        }
    }

    private ArrayList<ExampleItem> mExampleList;

    public ExampleAdapter(ArrayList<ExampleItem> exampleList) {
        mExampleList = exampleList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
