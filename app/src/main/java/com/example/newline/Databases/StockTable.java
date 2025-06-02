package com.example.newline.Databases;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;



@Entity
public class StockTable implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "st_name")
    private String st_name;
    @ColumnInfo(name = "st_volume")
    private String st_volume;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getSt_name() {
        return st_name;
    }
    public void setSt_name(String st_name) {
        this.st_name = st_name;
    }
    public String getSt_volume() {
        return st_volume;
    }
    public void setSt_volume(String st_volume) {
        this.st_volume = st_volume;
    }
    @Override
    public String toString() {
        return "StockTable{" +
                "id=" + id +
                ", st_name='" + st_name + '\'' +
                ", st_volume='" + st_volume + '\'' +
                '}';
    }
}
