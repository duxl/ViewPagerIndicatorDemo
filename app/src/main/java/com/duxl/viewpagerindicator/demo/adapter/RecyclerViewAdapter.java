package com.duxl.viewpagerindicator.demo.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.duxl.viewpagerindicator.demo.utils.DisplayUtil;

/**
 * create by duxl 2020/7/20
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private String mLabel;
    private int dp15;

    public RecyclerViewAdapter(Context context, String label) {
        this.mContext = context;
        this.mLabel = label;
        dp15 = DisplayUtil.dip2px(mContext, 15);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView tv = new TextView(mContext);
        RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(tv) {
        };
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView textView = (TextView) holder.itemView;
        textView.setTextSize(16);
        textView.setPadding(dp15, dp15, dp15, dp15);
        textView.setText(mLabel + "------Item------" + position);
    }

    @Override
    public int getItemCount() {
        return 30;
    }
}
