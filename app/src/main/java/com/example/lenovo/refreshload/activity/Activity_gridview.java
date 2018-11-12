package com.example.lenovo.refreshload.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.refreshload.R;
import com.example.lenovo.refreshload.adapter.Grid_view_adapter;
import com.example.lenovo.refreshload.itemdecoration.GridDividerItemDecoration;
import com.example.lenovo.refreshload.utils.Toaster;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengzhihua on 2018/11/2.17:48
 * Update 2018/11/2 17:48
 * Describe
 */

public class Activity_gridview extends AppCompatActivity{
    private RecyclerView recyclerView;
    private Grid_view_adapter homeAdapter;
    private List<String> list=new ArrayList<String>();
    private ImageView exit;
    private TextView titlename;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        setData();
        initview();
    }

    protected void setData() {
        for (int i = 0; i < 20; i++) {
            list.add("aaa" + i);
        }
    }
    /**
     * 初始化界面
     */
    protected void initview() {
        recyclerView = findViewById(R.id.grid_view);
        exit=findViewById(R.id.exit1_text);
        titlename=findViewById(R.id.titeword_text);
        titlename.setText("请选择司机");
        exit.setOnClickListener(exitOnClistener);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.addItemDecoration(new GridDividerItemDecoration(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        homeAdapter = new Grid_view_adapter(this, list,100);
        recyclerView.setAdapter(homeAdapter);
        homeAdapter.setItemOnClickListener(new Grid_view_adapter.ItemOnClickListener() {
            @Override
            public void ItemOnClick(View view, String username, int position) {
                Toaster.setShortToast(Activity_gridview.this,username);
            }
        });
    }

    View.OnClickListener exitOnClistener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

}
