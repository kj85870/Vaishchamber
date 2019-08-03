package com.test.global_test.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.test.global_test.Model.Supporter;
import com.test.global_test.R;

import java.util.List;

public class SupporterAdapter extends RecyclerView.Adapter<SupporterAdapter.MyViewHolder> {

    private List<Supporter> moviesList;
    private  Context context;
    Dialog mydialog;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre,text1,text2,text3;
        private Button btn;
        private ImageView image;


        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            btn = view.findViewById(R.id.Readmore);

        }
    }


    public SupporterAdapter(Context context,List<Supporter> moviesList) {
        this.moviesList = moviesList;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int i) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_supporter, parent, false);
          final MyViewHolder vHolder = new MyViewHolder(itemView);

          mydialog = new Dialog(context);
          mydialog.setContentView(R.layout.readmore);

          vHolder.btn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  TextView text1 = mydialog.findViewById(R.id.title);
                  TextView text2 = mydialog.findViewById(R.id.year);
                  text1.setText(moviesList.get(vHolder.getAdapterPosition()).getName());
//                  text2.setText(moviesList.get(vHolder.getAdapterPosition()).getImage());
                  Toast.makeText(context,"Success"+String.valueOf(vHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
                  mydialog.show();
              }
          });
            return new MyViewHolder(itemView);
        }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {
        Supporter movie = moviesList.get(position);
        holder.title.setText(movie.getName());
        holder.year.setText(movie.getId());
        holder.genre.setText((Integer) movie.getAddress());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}