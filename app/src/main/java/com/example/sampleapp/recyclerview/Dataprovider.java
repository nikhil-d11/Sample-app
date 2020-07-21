package com.example.sampleapp.recyclerview;

import java.util.ArrayList;


public class Dataprovider {

    public ArrayList<Model> getDataforRecyclerview(){
        ArrayList<Model> data=new ArrayList<Model>();

        data.add(new Model("vishnu"));
        data.add(new Model("ballu"));
        data.add(new Model("ashish"));
        data.add(new Model("shrey"));
        data.add(new Model("anurag"));
        data.add(new Model("nikhil"));
        data.add(new Model("baba"));
        data.add(new Model("shubham"));
        data.add(new Model("surya"));
        data.add(new Model("hritik"));
        data.add(new Model("parijat"));
        data.add(new Model("arnab"));

        return data;

    };
    
}
