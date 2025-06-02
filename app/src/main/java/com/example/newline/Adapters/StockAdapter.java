package com.example.newline.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newline.Databases.StockTable;
import com.example.newline.R;

import java.util.List;

public class StockAdapter extends RecyclerView.Adapter<StockAdapter.ViewHolder> {

    Context context;
    List<StockTable> stockTablesList;
    View view;

    public StockAdapter(Context context) {
        this.context = context;
    }


    public StockAdapter(Context context, List<StockTable> stockTablesList) {
        this.context = context;
        this.stockTablesList = stockTablesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.rv_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         if(stockTablesList != null && stockTablesList.size() > 0){
             StockTable stockTable = stockTablesList.get(position);
             holder.sl_no.setText(String.valueOf(stockTable.getId()));
             holder.name_rv.setText(stockTable.getSt_name());
             holder.volume_rv.setText(stockTable.getSt_volume());
         }
    }

    @Override
    public int getItemCount() {
        return stockTablesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView sl_no,name_rv,volume_rv;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            sl_no = itemView.findViewById(R.id.sl_no);
            name_rv = itemView.findViewById(R.id.name_rv);
            volume_rv = itemView.findViewById(R.id.volume_rv);
        }
    }
}
