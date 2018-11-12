package com.example.lenovo.refreshload;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lenovo.refreshload.activity.Activity_Cardview;
import com.example.lenovo.refreshload.activity.Activity_LineChart;
import com.example.lenovo.refreshload.activity.Activity_gridview;
import com.example.lenovo.refreshload.activity.Activity_image;
import com.example.lenovo.refreshload.activity.Activity_recycleview;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
 /*   @BindView(R.id.refresh)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recycle)
    RecyclerView recyclerView;*/
    @BindView(R.id.button1) Button button1;
    @BindView(R.id.button2) Button button2;
    @BindView(R.id.button3) Button button3;
    @BindView(R.id.button4) Button button4;
    @BindView(R.id.button5) Button button5;
    @BindView(R.id.button6) Button button6;
    @BindView(R.id.button7 ) Button button7;
    @BindView(R.id.button8) Button button8;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initview();
    }

    private void initview(){
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                startActivity(new Intent(MainActivity.this, Activity_recycleview.class));
                break;
            case R.id.button2:
                startActivity(new Intent(MainActivity.this, Activity_Cardview.class));
                break;
            case R.id.button3:
                startActivity(new Intent(MainActivity.this, Activity_gridview.class));
                break;
            case R.id.button4:
                startActivity(new Intent(MainActivity.this, Activity_LineChart.class));
                break;
            case R.id.button5:
                startActivity(new Intent(MainActivity.this, Activity_image.class));
                break;
            case R.id.button6:
                break;
            case R.id.button7:
            case R.id.button8:
        }
    }
}
