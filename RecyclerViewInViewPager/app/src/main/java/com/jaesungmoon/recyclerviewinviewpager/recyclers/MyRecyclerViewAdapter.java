package com.jaesungmoon.recyclerviewinviewpager.recyclers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaesungmoon.recyclerviewinviewpager.R;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {


    Context mContext;
    ArrayList<Movie> mMovieList;
    public MyRecyclerViewAdapter(Context context, ArrayList<Movie> movieList) {
        mContext = context;
        mMovieList = movieList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model, null);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nameTxt.setText(mMovieList.get(position).getName());
        holder.imageView.setImageResource(mMovieList.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }
}
