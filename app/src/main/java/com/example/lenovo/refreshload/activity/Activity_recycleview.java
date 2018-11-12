package com.example.lenovo.refreshload.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import com.example.lenovo.refreshload.R;

import com.example.lenovo.refreshload.adapter.Recycleview_adapter;
import com.example.lenovo.refreshload.itemdecoration.DividerItemDecoration;
import com.example.lenovo.refreshload.utils.Toaster;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengzhihua on 2018/10/31.21:57
 * Update 2018/10/31 21:57
 * Describe   显示recycle的activity
 */

public class Activity_recycleview extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView recyclerView;
    private Recycleview_adapter homeAdapter;
    private List<String> list=new ArrayList<String>();
    private ImageView exit,ruleType_personimage,ruleType_carimage;
    private RelativeLayout rulepersonType_select,rulecarType_select;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_recycle_view);
        setData();
        initview();
    }
    protected void setData(){
        for(int i=0;i<20;i++){
            list.add("aaa"+i);
        }
    }
    /**
     * 初始化界面
     */
    protected void initview(){
        recyclerView=findViewById(R.id.recycle_view);
        ruleType_personimage=findViewById(R.id.ruleType_personimage);
        ruleType_carimage=findViewById(R.id.ruleType_carimage);
        ruleType_carimage.setImageDrawable(getResources().getDrawable(R.drawable.ic_carb));
        rulepersonType_select=findViewById(R.id.rulepersonType_select);
        rulecarType_select=findViewById(R.id.rulecarType_select);
        rulepersonType_select.setOnClickListener(this);
        rulecarType_select.setOnClickListener(this);
        exit=findViewById(R.id.exit1_text);
        exit.setOnClickListener(this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(Activity_recycleview.this,DividerItemDecoration.VERTICAT_LIST,getResources().getColor(R.color.itemLine1)));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        homeAdapter=new Recycleview_adapter(this,list);
        recyclerView.setAdapter(homeAdapter);
        setHandle();
    }

    private void setHandle() {
        homeAdapter.setOnItemClickListener(new Recycleview_adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view,String aaa,int position) {
                Toaster.setShortToast(Activity_recycleview.this,aaa);
            }
        });
    }

    /**
     * 初始化选择违规的图片
     */
    protected void initTypeimage(){
        ruleType_carimage.setImageDrawable(getResources().getDrawable(R.drawable.ic_car));
        ruleType_personimage.setImageDrawable(getResources().getDrawable(R.drawable.ic_driver));
    }

    /**
     * 点击事件的处理
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rulepersonType_select:
                initTypeimage();
                ruleType_carimage.setImageDrawable(getResources().getDrawable(R.drawable.ic_carb));
                break;
            case R.id.rulecarType_select:
                initTypeimage();
                ruleType_personimage.setImageDrawable(getResources().getDrawable(R.drawable.ic_driverb));
                break;
            case R.id.exit1_text:
                finish();
                break;
        }
    }
}
