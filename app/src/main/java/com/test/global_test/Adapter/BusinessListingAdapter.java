package com.test.global_test.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.test.global_test.Activity.SpecialCategory;
import com.test.global_test.Model.BusinessListingModel;
import com.test.global_test.R;

import java.util.List;

public class BusinessListingAdapter extends RecyclerView.Adapter<BusinessListingAdapter.ViewHolder> {
    private Context context;
    private List<BusinessListingModel> list;


    public BusinessListingAdapter(Context context, List<BusinessListingModel> list){
        this.context = context;
        this.list = list;

    }
    @NonNull
    @Override
    public BusinessListingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.layout_fragment_business,viewGroup, false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final BusinessListingModel listingModel = list.get(i);
        viewHolder.textTitle.setText(listingModel.getName());
        viewHolder.textDescription.setText(Html.fromHtml(listingModel.getDescription()));
        Picasso.with(context)
                .load(listingModel.getImage())
                .placeholder(R.drawable.hotel)
                .fit()
                .noFade()
                .into(viewHolder.imageView);
        viewHolder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Listing Clicked",String.valueOf(listingModel.getId()));
                Intent intent = new Intent(context,SpecialCategory.class);
                intent.putExtra("listing_id",String.valueOf(listingModel.getId()));
                context.startActivity(intent);

            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textTitle, textDescription,textOpening,textclosing;
        public ImageView imageView;
        public Button btn,contactus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.title);
            textDescription = itemView.findViewById(R.id.year);
//            textclosing = itemView.findViewById(R.id.des);
            imageView = itemView.findViewById(R.id.hotelImage);
            btn = itemView.findViewById(R.id.Button);
            contactus = itemView.findViewById(R.id.contactus);
//            contactus.setOnClickListener((View.OnClickListener) this);
        }
    }
}
