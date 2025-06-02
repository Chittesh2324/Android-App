package com.example.newline.Helper;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.newline.DataViewerActivity;
import com.example.newline.Databases.DatabaseClient;
import com.example.newline.Databases.StockDatabase;
import com.example.newline.Databases.StockTable;

import java.util.List;

public class DatabaseHelper {
    Context context;

    public DatabaseHelper(Context context) {
        this.context = context;
    }

    public static DatabaseHelper getInstance(Context context){
        return new DatabaseHelper(context);
    }

    public void addNewStock(String st_name,String st_volume) {
        class NewStock extends AsyncTask<Void,Void, StockTable>{


            @Override
            protected StockTable doInBackground(Void... voids) {
                StockTable stockTable = new StockTable();
                stockTable.setSt_name(st_name);
                stockTable.setSt_volume(st_volume);

                DatabaseClient.getInstance(context)
                        .getStockDatabase()
                        .stockDAO()
                        .insertData(stockTable);
                return stockTable;
            }

            @Override
            protected void onPostExecute(StockTable stockTable) {
                super.onPostExecute(stockTable);
                if(stockTable != null){
                    Toast.makeText(context, stockTable.getSt_name() +"\n" +stockTable.getSt_volume(), Toast.LENGTH_SHORT).show();
                }
            }
        }

        NewStock newStock = new NewStock();
        newStock.execute();
    }

    public void getAllStockData(){
        class AllStock extends AsyncTask<Void,Void,List<StockTable>>{

            @Override
            protected List<StockTable> doInBackground(Void... voids) {
                List<StockTable> list =DatabaseClient.getInstance(context)
                        .getStockDatabase()
                        .stockDAO()
                        .selectAll();
                return list;
            }

            @Override
            protected void onPostExecute(List<StockTable> stockTables) {
                super.onPostExecute(stockTables);
                if(stockTables != null && stockTables.size() > 0) {
                    ((DataViewerActivity)context).setRecycler_view(stockTables);
                }
            }
        }
        AllStock allstock = new AllStock();
        allstock.execute();
    }
}
