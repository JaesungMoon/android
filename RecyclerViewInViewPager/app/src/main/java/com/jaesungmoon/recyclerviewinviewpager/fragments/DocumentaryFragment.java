package com.jaesungmoon.recyclerviewinviewpager.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaesungmoon.recyclerviewinviewpager.R;
import com.jaesungmoon.recyclerviewinviewpager.recyclers.Movie;
import com.jaesungmoon.recyclerviewinviewpager.recyclers.MyRecyclerViewAdapter;

import java.util.ArrayList;

public class DocumentaryFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.documentary_fragment, null);
        RecyclerView rv = v.findViewById(R.id.mRecyclerDoc);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new MyRecyclerViewAdapter(getActivity(), getDataList()));
        return v;
    }

    @Override
    public String toString() {
        return "Crime";
    }

    private ArrayList<Movie> getDataList() {
        ArrayList<Movie> movieList = new ArrayList<>();
        Movie m1 = new Movie("BlackList", R.drawable.ic_launcher_background);
        movieList.add(m1);

        Movie m2 = new Movie("BlackList1", R.drawable.ic_launcher_foreground);
        movieList.add(m2);
        Movie m3 = new Movie("BlackList2", R.drawable.ic_launcher_background);
        movieList.add(m3);

        return movieList;
    }
}
