package com.example.newline.Databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {StockTable.class},version = 1)
public abstract class StockDatabase extends RoomDatabase {
    public abstract stockDAO stockDAO();
}
