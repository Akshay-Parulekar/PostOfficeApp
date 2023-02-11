package com.example.postofficeapp.dao;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.postofficeapp.model.PincodeDetails;

import java.util.List;

@Dao
public interface PincodeDetailsDao
{
    @Insert
    void insert(PincodeDetails pincodeDetails);

    @Insert(onConflict = REPLACE)
    void insertOrUpdate(PincodeDetails pincodeDetails);

    @Insert
    void insertAll(List<PincodeDetails> list);

    @Insert(onConflict = REPLACE)
    void insertOrUpdateAll(List<PincodeDetails> list);

    @Update
    void update(PincodeDetails pincodeDetails);

    @Delete
    void delete(PincodeDetails pincodeDetails);

    @Query("select * from PincodeDetails where pincode like '%'||:str||'%' or circle like '%'||:str||'%' or division like '%'||:str||'%' or region like '%'||:str||'%' or office like '%'||:str||'%' or officeType like '%'||:str||'%' or delivery like '%'||:str||'%' or district like '%'||:str||'%' or state like '%'||:str||'%'")
    List<PincodeDetails> findBySomethingLike(String str);
}
