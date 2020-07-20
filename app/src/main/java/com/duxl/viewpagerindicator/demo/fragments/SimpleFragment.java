package com.duxl.viewpagerindicator.demo.fragments;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 单页面Fragment
 * create by duxl 2020/7/20
 */
public class SimpleFragment extends Fragment {

    public static SimpleFragment newInstance(String text) {
        SimpleFragment instance = new SimpleFragment();
        Bundle args = new Bundle();
        args.putString("text", text);
        instance.setArguments(args);
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView tv = new TextView(getContext());
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(30);
        tv.setText(getArguments().getString("text"));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        tv.setLayoutParams(layoutParams);
        return tv;
    }
}
