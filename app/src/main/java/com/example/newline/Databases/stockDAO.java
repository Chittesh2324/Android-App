package com.example.newline.Databases;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import kotlin.coroutines.jvm.internal.DebugMetadata;

@Dao
public interface stockDAO {

    @Insert
    void insertData(StockTable stockTable);

    @Query("SELECT * FROM stocktable")
    List<StockTable> selectAll();

}
