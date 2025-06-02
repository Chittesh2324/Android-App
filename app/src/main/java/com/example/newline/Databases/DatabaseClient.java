package com.example.newline.Databases;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public class DatabaseClient {

    Context context;
    static DatabaseClient client;
    StockDatabase stockDatabase;

    public DatabaseClient(Context context) {
        this.context = context;

        stockDatabase = Room.databaseBuilder(context,StockDatabase.class,"StudentDatabase").build();
    }

    public static synchronized  DatabaseClient getInstance(Context context) {
        if(client == null){
            client = new DatabaseClient(context);
        }
        return client;
    }

    public StockDatabase getStockDatabase(){
        return stockDatabase;
    }
}
