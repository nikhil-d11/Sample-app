package com.example.sampleapp.recyclerview;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class model {
    @PrimaryKey
    public int uid;
    @ColumnInfo(name="ischecked")
    public Boolean ischecked=false;
    @ColumnInfo(name = "name")
    public String name;

    public model(Boolean ischecked, String name) {
        this.ischecked = ischecked;
        this.name = name;
    }

    public model(String name) {
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
