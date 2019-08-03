package com.test.global_test.Fragments;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.test.global_test.Adapter.AddListingAdapter;
import com.test.global_test.Model.BusinessListingModel;
import com.test.global_test.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AddListingFragment extends Fragment {
    private BusinessFragment.OnFragmentInteractionListener mListener;
    private TextView textview;
    private RecyclerView mList;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<BusinessListingModel> modelList;
    private RecyclerView.Adapter adapter;
    private String url = "https://globalagra-vaishchamber.com/api/listing";


    public AddListingFragment() {
        // Required empty public constructor
    }

    public static AddListingFragment newInstance(String param1, String param2) {
        AddListingFragment fragment = new AddListingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {


        View view =  inflater.inflate(R.layout.fragment_add_listing, container, false);
        mList = view.findViewById(R.id.recycler_view);
        modelList = new ArrayList<>();
        adapter = new AddListingAdapter(getActivity(),modelList);
        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(),linearLayoutManager.getOrientation());
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        adapter.notifyDataSetChanged();
        mList.setAdapter(adapter);
        getData();
        return view;
    }

    private void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.e("Listing ", response.toString());
                for (int i = 0 ; i < response.length(); i++){
                    try
                    {
                        progressDialog.dismiss();
                        JSONObject jsonObject = response.getJSONObject(i);
                        BusinessListingModel model = new BusinessListingModel();
                        model.setId(jsonObject.getInt("id"));
                        model.setName(jsonObject.getString("name"));
                        model.setImage("https://globalagra-vaishchamber.com/images/listing/"+jsonObject.getString("image"));
                        model.setDescription(jsonObject.getString("description"));
                        model.setUserId(jsonObject.getInt("user id"));
                        model.setCategoryId(jsonObject.getInt("category id"));
                        model.setTagId(jsonObject.getInt("tag id"));
                        model.setLocations(jsonObject.getDouble("locations"));
                        model.setSlug(jsonObject.getString("slug"));
                        model.setPrice(jsonObject.getInt("price"));
                        model.setOpeningTime(jsonObject.getString("opening time"));
                        model.setClosingTime(jsonObject.getString("closing time"));
                        model.setViews(jsonObject.getString("views"));
                        model.setVideo(jsonObject.getString("video"));
                        model.setStatus(jsonObject.getInt("status"));
                        model.setCreatedAt(jsonObject.getString("created at"));
                        model.setUpdatedAt(jsonObject.getString("updated at"));
                        model.setWebsite(jsonObject.getString("website"));
                        model.setMetaTitle(jsonObject.getString("meta title"));
                        model.setMetaTags(jsonObject.getString("meta tags"));
                        model.setMetaDescription(jsonObject.getString("meta description"));
                        model.setCategoryName(jsonObject.getString("category name"));
                        model.setTagName(jsonObject.getString("tag name"));
                        model.setUserName(jsonObject.getString("user name"));
                        model.setUserEmail(jsonObject.getString("user email"));
                        model.setPhone(jsonObject.getString("phone"));
                        model.setAddress(jsonObject.getString("set address"));
                        model.setCity(jsonObject.getString("city"));
                        model.setArea(jsonObject.getString("area"));
                        model.setPincode(jsonObject.getInt("pincode"));
                        modelList.add(model);
                        adapter.notifyDataSetChanged();
                    }catch (JSONException e){
                        e.printStackTrace();
                        progressDialog.dismiss();
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
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(jsonArrayRequest);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}




