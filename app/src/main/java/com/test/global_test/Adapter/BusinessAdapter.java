package com.test.global_test.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.global_test.Model.BusinessListModel;
import com.test.global_test.R;

import java.util.List;

public class BusinessAdapter extends RecyclerView.Adapter<BusinessAdapter.MyViewHolder> {

    private List<BusinessListModel> businessListModelList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);
            title =  view.findViewById(R.id.title);
            image =  view.findViewById(R.id.image);
        }
    }


    public BusinessAdapter(Context context,List<BusinessListModel> businessListModelList) {
        this.businessListModelList = businessListModelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_fragment_business, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        BusinessListModel businesslist = businessListModelList.get(position);
        holder.title.setText(businesslist.getTitle());
//        holder.image.setImageResource(businesslist.getImage());
    }

    @Override
    public int getItemCount() {
        return businessListModelList.size();
    }
}