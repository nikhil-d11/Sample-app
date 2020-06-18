package com.example.sampleapp.RecyclerView;

import java.util.ArrayList;


public class Dataprovider {

    public ArrayList<model> getDataforRecyclerview(){
        ArrayList<model> data=new ArrayList<model>();

        data.add(new model("vishnu"));
        data.add(new model("ballu"));
        data.add(new model("ashish"));
        data.add(new model("shrey"));
        data.add(new model("anurag"));
        data.add(new model("nikhil"));
        data.add(new model("baba"));
        data.add(new model("shubham"));
        data.add(new model("surya"));
        data.add(new model("hritik"));
        data.add(new model("parijat"));
        data.add(new model("arnab"));

        return data;

    };
    
}
