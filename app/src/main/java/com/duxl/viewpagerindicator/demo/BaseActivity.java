package com.duxl.viewpagerindicator.demo;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * create by duxl 2020/6/28
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mUnbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        mUnbinder = ButterKnife.bind(this);
        initView();
    }

    public abstract int getLayoutResId();

    public void initView() {

    }

    public void hideActionBar(boolean hide) {
        if(getSupportActionBar() != null) {
            if(hide) {
                getSupportActionBar().hide();
            } else {
                getSupportActionBar().show();
            }
        }
    }

    public void setActionBarTitle(CharSequence title) {
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    protected void onDestroy() {
        if(mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroy();
    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
