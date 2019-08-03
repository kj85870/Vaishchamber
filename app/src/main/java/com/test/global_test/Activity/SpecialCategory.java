package com.test.global_test.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;
import com.test.global_test.Fragments.BusinessFragment;
import com.test.global_test.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SpecialCategory extends AppCompatActivity implements View.OnClickListener, DialogEnquiry.DialogListener{

    public TextView locations,name,description,price,slug,openingtime,closingtime,openingtime1,closingtime1,openingtime2,closingtime2,openingtime3,closingtime3,openingtime4,closingtime4,openingtime5,closingtime5,openingtime6,closingtime6,views,created,updated,website,metatitle,metatags,metadescription,categoryname,tagname,username,useremail,address,city,area,pincode;
    private ImageView image;
    private Integer status,userid,categoryid,id;
    private BusinessFragment.OnFragmentInteractionListener mListener;
    public String url = "https://globalagra-vaishchamber.com/api/listing";
    private String html;
    private Button btnDialogFragment;
    private TextView textView;
    private EditText name2,email2,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.specialcategory);
        Intent intent = getIntent();
        String id = intent.getStringExtra("listing_id");
        Log.e("Listing Id Passed " ,id);
        url = "https://globalagra-vaishchamber.com/api/listing/"+id;
        locations = findViewById(R.id.location);
        username = findViewById(R.id.username);
        image = findViewById(R.id.img);
        description = findViewById(R.id.des);
        price = findViewById(R.id.pricings);
        tagname = findViewById(R.id.tags);
        btnDialogFragment = findViewById(R.id.btnDialogFragment);
//        address = findViewById(R.id.address);
        closingtime6 = findViewById(R.id.closingtime1);
        openingtime6 = findViewById(R.id.openingtime1);
        closingtime1 = findViewById(R.id.closingtime2);
        openingtime1 = findViewById(R.id.openingtime2);
        closingtime2 = findViewById(R.id.closingtime3);
        openingtime2 = findViewById(R.id.openingtime3);
        closingtime3 = findViewById(R.id.closingtime4);
        openingtime3 = findViewById(R.id.openingtime4);
        closingtime4 = findViewById(R.id.closingtime5);
        openingtime = findViewById(R.id.openingtime);
        closingtime = findViewById(R.id.closingtime);
        openingtime4 = findViewById(R.id.openingtime5);
        closingtime5 = findViewById(R.id.closingtime6);
        openingtime5 = findViewById(R.id.openingtime6);
        name = findViewById(R.id.name);
        useremail = findViewById(R.id.email);
        views = findViewById(R.id.pricecategory);
        btnDialogFragment.setOnClickListener(this);
        getData();

    }
    private void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.e("Listing ", response.toString());
                for (int i = 0 ; i < response.length(); i++){
                    try
                    {
                        JSONObject jsonObject = response.getJSONObject(i);
                        name.setText(jsonObject.getString("name"));
                        description.setText(Html.fromHtml(jsonObject.getString("description")));
                        price.setText(Html.fromHtml(jsonObject.getString("price")));
                        locations.setText(jsonObject.getString("address"));
                        useremail.setText(jsonObject.getString("user_email"));
                        username.setText(jsonObject.getString("user_name"));
                        Picasso.with(getApplicationContext())
                                .load("https://globalagra-vaishchamber.com/images/listing/"+jsonObject.getString("image"))
                                .fit()
                                .into(image);
//                        phone.setText(jsonObject.getString("phone"));
//                        image.setImageResource(R.drawable.ic_menu_camera);
                        openingtime1.setText(jsonObject.getString("opening_time"));
                        closingtime1.setText(jsonObject.getString("closing_time"));
                        openingtime2.setText(jsonObject.getString("opening_time"));
                        closingtime2.setText(jsonObject.getString("closing_time"));
                        openingtime3.setText(jsonObject.getString("opening_time"));
                        closingtime3.setText(jsonObject.getString("closing_time"));
                        openingtime4.setText(jsonObject.getString("opening_time"));
                        closingtime4.setText(jsonObject.getString("closing_time"));
                        openingtime5.setText(jsonObject.getString("opening_time"));
                        closingtime5.setText(jsonObject.getString("closing_time"));
                        openingtime6.setText(jsonObject.getString("opening_time"));
                        closingtime6.setText(jsonObject.getString("closing_time"));
                        openingtime.setText(jsonObject.getString("opening_time"));
                        closingtime.setText(jsonObject.getString("closing_time"));
                        tagname.setText(jsonObject.getString("tag_name"));
                        views.setText(jsonObject.getString("views"));
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley ", error.toString());
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


            case R.id.btnDialogFragment:
                DialogEnquiry dialogFragment = new DialogEnquiry();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                dialogFragment = new DialogEnquiry();

                Bundle bundle = new Bundle();
                bundle.putBoolean("notAlertDialog",true);

                dialogFragment.setArguments(bundle);

                ft = getSupportFragmentManager().beginTransaction();
                Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);


                dialogFragment.show(ft,"dialog");
                break;
        }

    }

    @Override
    public void onFinishEditDialog(String inputText) {
        if (TextUtils.isEmpty(inputText)) {
            textView.setText("Email was not entered");
        } else
            textView.setText("Email entered: " + inputText);

    }
}
