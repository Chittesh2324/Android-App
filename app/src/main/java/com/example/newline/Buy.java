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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.newline.Helper.DatabaseHelper;

public class Buy extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home,buy,sale,overall,logout;


    EditText stock_name,stock_volume;
    DatabaseHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_buy);
        helper = DatabaseHelper.getInstance(this);


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
                redirectActivity(Buy.this,navigation.class);

            }
        });
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recreate();
            }
        });
        sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(Buy.this,Sale.class);
            }
        });
        overall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(Buy.this,Overall.class);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(Buy.this,MainActivity.class);
                Toast.makeText(Buy.this,"Logout Successfully",Toast.LENGTH_SHORT).show();
            }
        });

        stock_name = findViewById(R.id.stock_name);
        stock_volume = findViewById(R.id.stock_volume);

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

    public void submit(View view) {
        if(!stock_name.getText().toString().isEmpty() && !stock_volume.getText().toString().isEmpty() )
            helper.addNewStock(stock_name.getText().toString(),stock_volume.getText().toString());
    }

    public void show(View view) {
        startActivity(new Intent(this,DataViewerActivity.class));

    }

}