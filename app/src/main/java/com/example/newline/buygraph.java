package com.example.newline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import android.graphics.Color;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class buygraph extends AppCompatActivity
 {

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home,buy,sale,overall,logout;

     private List<String> xValues = Arrays.asList("Reliance","Myntra","Aravindh Mill","Newline");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_buygraph);

        drawerLayout=findViewById(R.id.drawerLayout);
        menu=findViewById(R.id.menu);
        home=findViewById(R.id.home);
        buy=findViewById(R.id.Buyings);
        sale=findViewById(R.id.Sales);
        overall=findViewById(R.id.TotalStock);
        logout=findViewById(R.id.logout);

        menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openDrawer(drawerLayout);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(buygraph.this,navigation.class);

            }
        });
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(buygraph.this,Buy.class);
            }
        });
        sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(buygraph.this,Sale.class);
            }
        });
        overall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(buygraph.this,Overall.class);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(buygraph.this,MainActivity.class);
                Toast.makeText(buygraph.this,"Logout Successfully",Toast.LENGTH_SHORT).show();
            }
        });


            BarChart barChart = findViewById(R.id.chart);
            barChart.getAxisRight().setDrawLabels(false);

            ArrayList <BarEntry> entries = new ArrayList<>();
            entries.add(new BarEntry(0,45f));
            entries.add(new BarEntry(1,80f));
            entries.add(new BarEntry(2,65f));
            entries.add(new BarEntry(3,38f));

            YAxis yAxis = barChart.getAxisLeft();
            yAxis.setAxisMaximum(0f);
            yAxis.setAxisMaximum(100f);
            yAxis.setAxisLineWidth(2f);
            yAxis.setAxisLineColor(Color.BLACK);
            yAxis.setLabelCount(10);

            BarDataSet dataSet = new BarDataSet(entries, "Companies");
            dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

            BarData barData = new BarData(dataSet);
            barChart.setData(barData);

            barChart.getDescription().setEnabled(false);
            barChart.invalidate();

            barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(xValues));
            barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
            barChart.getXAxis().setGranularity(1f);
            barChart.getXAxis().setGranularityEnabled(true);
    }
    public static void openDrawer(DrawerLayout drawerLayout)
    {
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public static void closeDrawer(DrawerLayout drawerLayout)
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public static void redirectActivity(Activity activity, Class secondActivity)
    {
        Intent intent = new Intent(activity,secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}