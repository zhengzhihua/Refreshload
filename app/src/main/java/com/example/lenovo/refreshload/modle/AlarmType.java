package com.example.lenovo.refreshload.modle;

import java.io.Serializable;

/**
 * Created by zhengzhihua on 2018/11/4.11:33
 * Update 2018/11/4 11:33
 * Describe
 */

public class AlarmType implements Serializable {
    private String alarmtype;   //报警类型
    private boolean isselected;  //是否选中该报警类型
    public AlarmType(String alarmtype,boolean isselected){
        this.alarmtype=alarmtype;
        this.isselected=isselected;
    }

    public String getAlarmtype() {
        return alarmtype;
    }

    public void setAlarmtype(String alarmtype) {
        this.alarmtype = alarmtype;
    }

    public boolean isIsselected() {
        return isselected;
    }

    public void setIsselected(boolean isselected) {
        this.isselected = isselected;
    }
}
