package com.money.debt.bean;

import java.io.Serializable;

public class EntrustQuery implements Serializable{

    private String name;//委托方
    private String fromTimeStr;
    private String endTimeStr;



    public String getName() {

        return name;
    }

    public void setName(String name) {
        if ("".equals(name)){
            this.name=null;
            return;
        }
        this.name = name;
    }

    public String getFromTimeStr() {

        return fromTimeStr;
    }

    public void setFromTimeStr(String fromTimeStr) {
        if(fromTimeStr!=null&&fromTimeStr.length()>0) {
            String month = fromTimeStr.substring(0, 2);
            String day = fromTimeStr.substring(3, 5);
            String year = fromTimeStr.substring(6);

            this.fromTimeStr = year + "-" + month + "-" + day;

        }else{
            this.fromTimeStr = null;
        }



    }

    public String getEndTimeStr() {

        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        if(endTimeStr!=null&&endTimeStr.length()>0){
            String month=endTimeStr.substring(0,2);
            String day=endTimeStr.substring(3,5);
            String year=endTimeStr.substring(6);

            this.endTimeStr = year+"-"+month+"-"+day;

        }else {
            this.endTimeStr = null;
        }


    }
}
