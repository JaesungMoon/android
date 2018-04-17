package com.jaesungmoon.listviewex.model;

/**
 * Created by moon_jaesung on 2018/04/17.
 */

public class ColorItem {
    private final String nameEnglish;
    private final String nameJapanese;
    private final int imageId;

    public ColorItem(String nameEnglish, String nameJapanese, int imageId) {
        this.nameEnglish = nameEnglish;
        this.nameJapanese = nameJapanese;
        this.imageId = imageId;
    }

    public String getNameEnglish() {
        return nameEnglish;
    }

    public String getNameJapanese() {
        return nameJapanese;
    }

    public int getImageId() {
        return imageId;
    }
}