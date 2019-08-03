package com.test.global_test.Model;

public class Movie {
    private String title, year,price;

    public Movie() {
    }

    public Movie(String title,String price,String year) {
        this.title = title;
        this.year = year;
        this.price = price;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String year) {
        this.price = year;
    }



}