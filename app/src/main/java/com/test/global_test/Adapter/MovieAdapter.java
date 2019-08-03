package com.test.global_test.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.test.global_test.Activity.SpecialCategory;
import com.test.global_test.Fragments.MobieFragment;
import com.test.global_test.Model.Movie;
import com.test.global_test.R;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder>  {

    private List<Movie> moviesList;
    private Context mContext ;

    public MovieAdapter(MobieFragment mobieFragment,List<Movie> listCont) {

    }


    public class MyViewHolder extends RecyclerView.ViewHolder  {
        public Context context;
        public TextView title, year, price;
        public LinearLayout linearLayout;
        public Button btn;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            price = (TextView) view.findViewById(R.id.price);
            year = (TextView) view.findViewById(R.id.year);
            btn = view.findViewById(R.id.Button);


        }
    }



    public MovieAdapter(Context mContext,List<Movie> moviesList) {
        this.moviesList = moviesList;
        this.mContext = mContext;


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_fragment_business, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position) {
        Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.price.setText(movie.getPrice());
        holder.year.setText(movie.getYear());
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,SpecialCategory.class);

//                // passing data to the book activity
                intent.putExtra("Title",moviesList.get(position).getTitle());
                intent.putExtra("Price",moviesList.get(position).getPrice());
                intent.putExtra("Year",moviesList.get(position).getYear());
                // start the activity
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
