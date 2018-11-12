package com.example.lenovo.refreshload;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhengzhihua on 2018/10/26.9:12
 * Update 2018/10/26 9:12
 * Describe
 */

public class Adapter_recycle extends RecyclerView.Adapter<Adapter_recycle.ViewHolder>{
    public OnItemClickListener onItemClickListener;
    public Adapter_recycle(){

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
}
