package com.example.lenovo.refreshload.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by zhengzhihua on 2018/11/1.9:33
 * Update 2018/11/1 9:33
 * Describe   吐司
 */

public class Toaster {

    public static void setShortToast(Context context,String s){
        if(context!=null && !s.equals(null)){
           Toast.makeText(context,s,Toast.LENGTH_SHORT).show();
        }
    }
}
