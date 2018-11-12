package com.example.lenovo.refreshload.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.refreshload.R;
import com.example.lenovo.refreshload.view.HeadImageView;

import java.util.List;

/**
 * Created by zhengzhihua on 2018/11/2.17:44
 * Update 2018/11/2 17:44
 * Describe
 */

public class Grid_view_adapter extends RecyclerView.Adapter<Grid_view_adapter.MyViewHolder> implements View.OnClickListener{
    private Context context;
    private int windowweight;
    private ItemOnClickListener itemOnClickListener;
    private List list;
    public Grid_view_adapter(Context context, List list,int windowweight){
        this.context=context;
        this.windowweight=windowweight;
        this.list=list;
        Log.i("bbbbbb", "AlarmTypeAdapter: "+windowweight);
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.gridview_item,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        view.setOnClickListener(this);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.itemView.setTag(position);
//        RecyclerView.LayoutParams params= (RecyclerView.LayoutParams) holder.alarmLy.getLayoutParams();
//        params.width=windowweight/3;
//        holder.alarmLy.setLayoutParams(params);
        holder.numText.setText(String.valueOf(list.get(position)));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {
        itemOnClickListener.ItemOnClick(v, (String) list.get((Integer) v.getTag()),(Integer)v.getTag());
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout alarmLy;
        private HeadImageView alarmImage;
        private TextView numText;


        public MyViewHolder(View itemView) {
            super(itemView);
 //           alarmLy=itemView.findViewById(R.id.alarm_item_ly);
            alarmImage=itemView.findViewById(R.id.alarm_type_image);
            numText=itemView.findViewById(R.id.alarm_num_text);

        }
    }
    public interface ItemOnClickListener{
        public void ItemOnClick(View view,String username,int position);
    }

    public void setItemOnClickListener(ItemOnClickListener itemOnClickListener){
        this.itemOnClickListener=itemOnClickListener;
    }
}
