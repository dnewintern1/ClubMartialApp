package com.base.clubmartialapporiginal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.base.clubmartialapporiginal.model.DatabaseHandler;
import com.base.clubmartialapporiginal.model.MartialArt;

public class Add_Martial_Art extends AppCompatActivity implements  View.OnClickListener {

    EditText edtname, edtprice , edtcolor;
    Button btnAddmartialart, btnback;

    DatabaseHandler mDatabaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_martial_art);

        edtname = findViewById(R.id.edtname);
        edtprice = findViewById(R.id.edtprice);
        edtcolor = findViewById(R.id.edtcolor);
        btnAddmartialart = findViewById(R.id.btnAddmartialart);
        btnback = findViewById(R.id.btnback);

        btnAddmartialart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMartialArtObjectToDatabase();
            }
        });






        Toast.makeText(Add_Martial_Art.this , "its the add activity", Toast.LENGTH_SHORT).show();
    }

    private void addMartialArtObjectToDatabase(){

        String nameValue = edtname.getText().toString();
        String nameColor = edtcolor.getText().toString();
        String namePrice = edtprice.getText().toString();

        try {
            double priceDoulbleValue = Double.parseDouble(namePrice);
            MartialArt martialArtObject = new MartialArt(0,nameValue,priceDoulbleValue,nameColor);
            mDatabaseHandler = new DatabaseHandler(Add_Martial_Art.this);
            mDatabaseHandler.addMartialArt(martialArtObject);
            Toast.makeText(Add_Martial_Art.this, martialArtObject + "MartialArt object is added to the database", Toast.LENGTH_SHORT).show();


        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void onClick(View v) {

    }
}