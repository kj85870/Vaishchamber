package com.test.global_test.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.test.global_test.R;

import java.util.ArrayList;
import java.util.List;

public class Main_Activity1 extends AppCompatActivity {

    List<Book> lstBook ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        lstBook = new ArrayList<>();
        lstBook.add(new Book("Hotel","Categorie Book","Lorem Description",R.drawable.hotel));
        lstBook.add(new Book("Fashion","Categorie Book","Lorem Description ",R.drawable.fashion));
        lstBook.add(new Book("Caterers","Categorie Book"," Lorem Description",R.drawable.caterers));
        lstBook.add(new Book("Jewelery","Categorie Book","Lorem Description",R.drawable.jewelery));
        lstBook.add(new Book("Painters","Categorie Book","Lorem Description ",R.drawable.painters));
        lstBook.add(new Book("Clubs","Categorie Book"," Lorem Description",R.drawable.clubs));
        lstBook.add(new Book("Hotel","Categorie Book","Lorem Description",R.drawable.hotel));
        lstBook.add(new Book("Fashion","Categorie Book","Lorem Description ",R.drawable.fashion));
        lstBook.add(new Book("Caterers","Categorie Book"," Lorem Description",R.drawable.caterers));
        lstBook.add(new Book("Jewelery","Categorie Book","Lorem Description",R.drawable.jewelery));
        lstBook.add(new Book("Painters","Categorie Book","Lorem Description ",R.drawable.painters));
        lstBook.add(new Book("Clubs","Categorie Book"," Lorem Description",R.drawable.clubs));
        lstBook.add(new Book("Hotel","Categorie Book","Lorem Description",R.drawable.hotel));
        lstBook.add(new Book("Fashion","Categorie Book","Lorem Description ",R.drawable.fashion));
        lstBook.add(new Book("Caterers","Categorie Book"," Lorem Description",R.drawable.caterers));
        lstBook.add(new Book("Jewelery","Categorie Book","Lorem Description",R.drawable.jewelery));
        lstBook.add(new Book("Painters","Categorie Book","Lorem Description ",R.drawable.painters));
        lstBook.add(new Book("Clubs","Categorie Book"," Lorem Description",R.drawable.clubs));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstBook);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);


    }
}
