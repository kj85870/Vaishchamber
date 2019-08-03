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
import com.squareup.picasso.Picasso;
import com.test.global_test.Model.AboutModel;
import com.test.global_test.R;
import java.util.List;

public class AboutAdapter extends RecyclerView.Adapter<AboutAdapter.ViewHolder> {
    private Context context;
    private List<AboutModel> list;


    public AboutAdapter(Context context, List<AboutModel> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AboutAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.layout_about,viewGroup, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        AboutModel listingModel = list.get(i);
        viewHolder.textTitle.setText(listingModel.getTitle());
//        viewHolder.textId.setId(listingModel.getId());
//        viewHolder.textCreated.setText(listingModel.getCreatedAt());
        viewHolder.textDescription.setText(Html.fromHtml(listingModel.getContent()));
        Picasso.with(context)
                .load(listingModel.getImage())
                .placeholder(R.drawable.hotel)
                .fit()
                .noFade()
                .into(viewHolder.imageView);
//        viewHolder.btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(context,SpecialCategory.class);
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
        public TextView textTitle, textDescription,textId,textCreated,textUpdated;
        public ImageView imageView;
        public Button btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.abouttitle);
            textId = itemView.findViewById(R.id.aboutid);
            textDescription = itemView.findViewById(R.id.aboutcontent);
            imageView = itemView.findViewById(R.id.aboutimg);

        }
    }
}
