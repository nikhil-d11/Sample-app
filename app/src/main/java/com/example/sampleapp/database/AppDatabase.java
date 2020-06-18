package com.example.sampleapp.recyclerview;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.sampleapp.database.ModelDao;

@Database(entities = {Model.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String db_name="ChecklistDB";
    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,db_name)
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return instance;
    }

    public abstract ModelDao modelDao();


}
