package com.test.global_test.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.global_test.Activity.Settings;
import com.test.global_test.AddPosts;
import com.test.global_test.R;

import static com.test.global_test.R.id.addposts;
import static com.test.global_test.R.id.editprofile;
import static com.test.global_test.R.id.settings;

public class ProfileFragment extends Fragment implements View.OnClickListener {
    private FloatingActionButton b,bone,btwo;


    public ProfileFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        FloatingActionButton b = (FloatingActionButton) v.findViewById(editprofile);
        b.setOnClickListener(this);
        FloatingActionButton btwo = (FloatingActionButton) v.findViewById(addposts);
        btwo.setOnClickListener(this);
        FloatingActionButton bone = (FloatingActionButton) v.findViewById(settings);
        bone.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case editprofile:
                startActivity(new Intent(getContext(),EditProfile.class));
                break;
            case settings:
                startActivity(new Intent(getContext(),Settings.class));
                break;
            case addposts:
                startActivity(new Intent(getContext(),AddPosts.class));
                break;
        }
    }}

