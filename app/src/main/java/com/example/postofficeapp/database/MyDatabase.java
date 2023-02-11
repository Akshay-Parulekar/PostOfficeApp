package com.example.postofficeapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.postofficeapp.dao.PincodeDetailsDao;
import com.example.postofficeapp.model.PincodeDetails;

@Database(entities = {PincodeDetails.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {

    private static MyDatabase instance;

    public abstract PincodeDetailsDao PincodeDetailsDao();

    public static synchronized MyDatabase getInstance(Context context) {

        if (instance == null) {

            instance =

                    androidx.room.Room.databaseBuilder(context.getApplicationContext(),
                            MyDatabase.class, "postofficeappdb")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .createFromAsset("postofficeappdb.db")
                            .build();
        }
        return instance;
    }
}
