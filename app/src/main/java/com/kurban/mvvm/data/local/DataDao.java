package com.kurban.mvvm.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DataDao {

    @Insert
    void insert(LocalModel... model);

    @Delete
    void delete(LocalModel model);

    @Query("SELECT * FROM data")
    LiveData<List<LocalModel>> getAllData();
}
