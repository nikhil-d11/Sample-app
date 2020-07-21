package com.example.sampleapp.recyclerview;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "model")
public class Model {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name="ischecked")
    public Boolean ischecked=false;
    @ColumnInfo(name = "name")
    public String name;


    public Model(int uid, Boolean ischecked, String name) {
        this.uid = uid;
        this.ischecked = ischecked;
        this.name = name;
    }

    @Ignore
    public Model(String name) {
        this.name = name;
    }

    public Boolean getIschecked() {
        return ischecked;
    }

    public void setIschecked(Boolean ischecked) {
        this.ischecked = ischecked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
