package com.example.lenovo.refreshload.activity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.lenovo.refreshload.R;
import com.example.lenovo.refreshload.util;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhengzhihua on 2018/11/1.11:05
 * Update 2018/11/1 11:05
 * Describe
 */

public class Activity_image extends AppCompatActivity{
    @BindView(R.id.imageview)
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image);
        ButterKnife.bind(this);
        initview();
    }

    private void initview(){
        Resources r = getApplication().getResources();
        Bitmap bmp= BitmapFactory.decodeResource(r, R.drawable.a);
        imageView.setImageBitmap(util.creatnew(bmp,"hello"));
    }
}
