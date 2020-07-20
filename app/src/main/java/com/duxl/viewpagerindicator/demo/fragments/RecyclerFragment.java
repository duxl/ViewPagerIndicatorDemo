package com.duxl.viewpagerindicator.demo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.duxl.viewpagerindicator.demo.R;
import com.duxl.viewpagerindicator.demo.adapter.RecyclerViewAdapter;

/**
 * 列表页面Fragment
 * create by duxl 2020/7/20
 */
public class RecyclerFragment extends Fragment {

    public static RecyclerFragment newInstance(String label) {
        RecyclerFragment instance = new RecyclerFragment();
        Bundle args = new Bundle();
        args.putString("label", label);
        instance.setArguments(args);
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = new RecyclerView(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.list_divider));
        recyclerView.addItemDecoration(itemDecoration);

        recyclerView.setAdapter(new RecyclerViewAdapter(getContext(), getArguments().getString("label")));

        return recyclerView;
    }


}
