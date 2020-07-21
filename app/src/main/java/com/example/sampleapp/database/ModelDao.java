package com.example.sampleapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.sampleapp.recyclerview.Model;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ModelDao {

    @Query("select * from model")
    List<Model> getAll();

    @Insert
    void insert(Model model);

    @Delete
    void delete(Model model);

}
