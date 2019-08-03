package com.test.global_test.Fragments;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.test.global_test.Adapter.CategoryAdapter;
import com.test.global_test.Model.CategoryModel;
import com.test.global_test.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class HomeCategoryFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    private RecyclerView recyclerViewCategory;
    private LinearLayoutManager linearLayoutManager;
    private List<CategoryModel> categoryModelList;
    private RecyclerView.Adapter adapter;
    private String url = "https://globalagra-vaishchamber.com/api/category";

    public HomeCategoryFragment() {
        // Required empty public constructor
    }

    public static HomeCategoryFragment newInstance(String param1,String param2) {
        HomeCategoryFragment fragment = new HomeCategoryFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_category,container,false);
        recyclerViewCategory = view.findViewById(R.id.recycler_view_category);
        categoryModelList = new ArrayList<>();
        adapter = new CategoryAdapter(getActivity(), categoryModelList);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewCategory.setLayoutManager(linearLayoutManager);
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));
        adapter.notifyDataSetChanged();
        recyclerViewCategory.setAdapter(adapter);
        getData();
        return view;
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
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
                        CategoryModel model = new CategoryModel();
                        model.setId(jsonObject.getInt("id"));
                        model.setName(jsonObject.getString("name"));
                        model.setImage("https://globalagra-vaishchamber.com/images/category/"+jsonObject.getString("image"));
                        model.setDescription(jsonObject.getString("description"));
                        Log.e("Category Image Link ", "https://globalagra-vaishchamber.com/images/category/"+jsonObject.getString("image"));
                        categoryModelList.add(model);
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
}
