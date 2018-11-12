package com.example.lenovo.refreshload.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.refreshload.Adapter_recycle;
import com.example.lenovo.refreshload.R;

import java.util.List;

/**
 * Created by zhengzhihua on 2018/10/31.21:16
 * Update 2018/10/31 21:16
 * Describe  recycleview适配器
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> implements View.OnClickListener,View.OnLongClickListener{
    public Adapter_recycle.OnItemClickListener onItemClickListener;
    private List<String> mList;
    private Context mContext;

    public HomeAdapter(Context mContext,List<String> mList){
        this.mContext=mContext;
        this.mList=mList;
    }

    public void removeData(int position){
        mList.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(mContext).inflate(R.layout.item_recycleview,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
           holder.itemView.setTag(position);
           holder.tv.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onClick(View v) {
        if(onItemClickListener !=null){
            onItemClickListener.onItemClick(v, (Integer) v.getTag());
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if(onItemClickListener !=null){
            onItemClickListener.onItemLongClick(v, (Integer) v.getTag());
            return true;
        }
        return false;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.text_item);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);
    }
    public void setOnItemClickListener(Adapter_recycle.OnItemClickListener onItemClickListener){
        this.onItemClickListener= onItemClickListener;
    }

}
