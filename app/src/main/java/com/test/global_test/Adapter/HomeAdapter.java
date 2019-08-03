//package com.test.global_test.Adapter;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.test.global_test.R;
//
//import java.util.List;
//
//public class HomeAdapter  extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
//
//    private List<HomeModel> moviesList;
//    private Context mContext;
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        public TextView title, location;
//
//        public MyViewHolder(View view) {
//            super(view);
//            title = (TextView) view.findViewById(R.id.title);
//            location = (TextView) view.findViewById(R.id.Opening);
//        }
//    }
//
//
//    public HomeAdapter(Context context,List<HomeModel> moviesList) {
//        this.moviesList = moviesList;
//        this.mContext = mContext;
//    }
//
//    @Override
//    public HomeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.layout_home,parent,false);
//
//        return new HomeAdapter.MyViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(HomeAdapter.MyViewHolder holder,int position) {
//        HomeModel movie = moviesList.get(position);
//        holder.title.setText(movie.getTitle());
////        holder.location.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////                Intent intent = new Intent(mContext,LocationTracer.class);
////
//////                // passing data to the book activity
////                // start the activity
////                mContext.startActivity(intent);
////            }
////        });
//
//    }
//
//
//    @Override
//    public int getItemCount() {
//        return moviesList.size();
//    }
//}
