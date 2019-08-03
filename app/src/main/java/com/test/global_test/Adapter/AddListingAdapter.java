package com.test.global_test.Adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.global_test.Model.BusinessListingModel;
import com.test.global_test.R;

import java.util.List;

public class AddListingAdapter extends RecyclerView.Adapter<AddListingAdapter.ViewHolder> {
    private Context context;
    private List<BusinessListingModel> list;


    public AddListingAdapter(Context context, List<BusinessListingModel> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AddListingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.fragment_add_listing,viewGroup, false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final BusinessListingModel listingModel = list.get(i);
        viewHolder.name.setText(listingModel.getName());
        viewHolder.category.setId(listingModel.getCategoryId());
        viewHolder.address.setText(listingModel.getAddress());
        viewHolder.area.setText(listingModel.getArea());
        viewHolder.city.setText(listingModel.getCity());
        viewHolder.zipcode.setText(listingModel.getPincode());
        viewHolder.price.setText(listingModel.getPrice());
        viewHolder.listingdes.setText(listingModel.getDescription());
//        viewHolder.metatag.setText(listingModel.getMetaTags());
        viewHolder.metatitle.setText(listingModel.getMetaTitle());
        viewHolder.listingdes.setText(Html.fromHtml(listingModel.getDescription()));
//        Picasso.with(context)
//                .load(listingModel.getImage())
//                .placeholder(R.drawable.hotel)
//                .fit()
//                .noFade()
//                .into(viewHolder.imageView);
//        viewHolder.btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("Listing Clicked", String.valueOf(listingModel.getId()));
//                Intent intent = new Intent(context,SpecialCategory.class);
//                intent.putExtra("listing_id", String.valueOf(listingModel.getId()));
//                context.startActivity(intent);
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name,category,address,area,city,listingdes,metatitle,metatag,zipcode,price;
        public ImageView imageView;
        public Button btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

           name = itemView.findViewById(R.id.firstNameEdit);
            category = itemView.findViewById(R.id.editLastName);
            imageView = itemView.findViewById(R.id.editPhone);
            btn = itemView.findViewById(R.id.Button);
            address = itemView.findViewById(R.id.addressEdit);
            city = itemView.findViewById(R.id.cityEdit);
            zipcode = itemView.findViewById(R.id.postalEdit);
            area = itemView.findViewById(R.id.address2Edit);
            price = itemView.findViewById(R.id.countryEdit);
             listingdes = itemView.findViewById(R.id.countryEdittwo);
            metatitle = itemView.findViewById(R.id.countryEditthree);
            metatag = itemView.findViewById(R.id.countryEditfour);

        }
    }
}
