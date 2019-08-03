package com.test.global_test.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.test.global_test.Adapter.MovieAdapter;
import com.test.global_test.Model.Movie;
import com.test.global_test.R;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.LinearLayoutManager.*;

public class MobieFragment extends Fragment {
    View v;
    RecyclerView recyclerView;
    private MovieAdapter mAdapter;
    List<Movie> getListCont = new ArrayList<>();
    List<Movie> listCont;

    public MobieFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_business,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        MovieAdapter viewAdapter = new MovieAdapter(getContext(),listCont);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(viewAdapter);

//        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
//                DividerItemDecoration.VERTICAL));
        DividerItemDecoration itemDecorator = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(getContext(),R.drawable.divider));
        return v;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listCont = new ArrayList<>();
        listCont.add(new Movie("Archana Estates","$0.0","New Delhi"));
        listCont.add(new Movie("Archana Estates","$0.0","New Delhi"));
        listCont.add(new Movie("Archana Estates","$0.0","New Delhi"));
        listCont.add(new Movie("Archana Estates","$0.0","New Delhi"));
        listCont.add(new Movie("Archana Estates","$0.0","New Delhi"));
        listCont.add(new Movie("Archana Estates","$0.0","New Delhi"));
        listCont.add(new Movie("Archana Estates","$0.0","New Delhi"));
        listCont.add(new Movie("Archana Estates","$0.0","New Delhi"));
        listCont.add(new Movie("Archana Estates","$0.0","New Delhi"));
//        MovieAdapter myAdapter = new MovieAdapter(this,listCont);
////        recyclerView.setLayoutManager(new GridLayoutManager(this,4));
//        recyclerView.setAdapter(myAdapter);


    }



}

