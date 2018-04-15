package com.jaesungmoon.recyclerviewinviewpager.recyclers;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaesungmoon.recyclerviewinviewpager.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameTxt;
    ItemClickListener itemClickListener;

    public MyViewHolder(View itemView) {
        super(itemView);


        imageView = itemView.findViewById(R.id.movieImage);
        nameTxt = itemView.findViewById(R.id.nameText);


    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
