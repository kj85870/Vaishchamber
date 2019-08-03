package com.test.global_test.Model;


import android.widget.ImageView;

public class BusinessListModel {
//    private int image;
    private String title;

    public BusinessListModel() {
    }

    public BusinessListModel(String title) {
        this.title = title;
//        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }
//    public int getImage() {
//        return image;
//    }
//
//    public void setImage(int image) {
//        this.image = image;
//    }
}
