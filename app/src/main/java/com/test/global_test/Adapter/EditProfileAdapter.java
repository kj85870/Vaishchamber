package com.test.global_test.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.test.global_test.Model.EditProfileModel;
import com.test.global_test.R;

import java.util.List;

public class EditProfileAdapter extends RecyclerView.Adapter<EditProfileAdapter.ViewHolder> {
    private Context context;
    private List<EditProfileModel> list;


    public EditProfileAdapter(Context context, List<EditProfileModel> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EditProfileAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.update_profile_layout,viewGroup, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        EditProfileModel profileModel = list.get(i);
//        viewHolder.name.setName(profileModel.getName());
//        viewHolder.textDescription.setText(Html.fromHtml(profileModel.getName()));
//        viewHolder.name.setTEXT()
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
        public EditText id;

       public EditText name,mobile,email,userId,createdAt,updatedAt;

        public EditText address,pincode,fax,birthdate,caste,originalplace,loksabha,vibhansabha,panchayat,businessname,officeaddress,categoryId,celebrity,celebrityDetails,married,image,
        familyId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

//            textTitle = itemView.findViewById(R.id.title);

        }
    }
}

