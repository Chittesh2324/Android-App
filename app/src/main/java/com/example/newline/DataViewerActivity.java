package com.example.newline;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newline.Adapters.StockAdapter;
import com.example.newline.Databases.StockTable;
import com.example.newline.Helper.DatabaseHelper;

import java.util.List;

public class DataViewerActivity extends AppCompatActivity {

    RecyclerView recycler_view;
    StockAdapter stockAdapter;
    DatabaseHelper helper;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_data_viewer);
        helper = DatabaseHelper.getInstance(this);

        recycler_view = findViewById(R.id.recycler_view);

        helper.getAllStockData();
    }
    public void setRecycler_view(List<StockTable> stockTablesList){
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        stockAdapter = new StockAdapter(this,stockTablesList);
        recycler_view.setAdapter(stockAdapter);
    }
}
