package com.example.lenovo.refreshload.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.lenovo.refreshload.Adapter_recycle;
import com.example.lenovo.refreshload.R;

import java.util.List;

/**
 * Created by zhengzhihua on 2018/11/4.11:17
 * Update 2018/11/4 11:17
 * Describe   recycleview的自定义适配器
 */

public class Recycleview_adapter extends RecyclerView.Adapter<Recycleview_adapter.MyViewHolder> implements View.OnClickListener{
    public Recycleview_adapter.OnItemClickListener onItemClickListener;
    private List<String> mList;
    private Context mContext;
    private MyViewHolder myViewHolder;

    public Recycleview_adapter(Context mContext,List<String> mList){
        this.mContext=mContext;
        this.mList=mList;
    }

    public void removeData(int position){
        mList.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_recycleview,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        view.setOnClickListener(this);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        myViewHolder=holder;
        myViewHolder.itemView.setTag(position);
        myViewHolder.tv.setText(mList.get(position));

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onClick(View v) {
        if(onItemClickListener !=null){
            onItemClickListener.onItemClick(v,mList.get((Integer) v.getTag()) ,(Integer) v.getTag());
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.text_item);

        }
    }

    public interface OnItemClickListener{
        void onItemClick(View view,String aa,int position);

    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener= onItemClickListener;
    }
}
