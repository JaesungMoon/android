package com.jaesungmoon.recyclerviewinviewpager.recyclers;

public class Movie {


    public Movie(String name, int img) {
        this.name = name;
        this.img = img;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    private int img;
}
