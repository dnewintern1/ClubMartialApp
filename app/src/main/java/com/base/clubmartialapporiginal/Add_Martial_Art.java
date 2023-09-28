package com.base.clubmartialapporiginal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Add_Martial_Art extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_martial_art);


        Toast.makeText(Add_Martial_Art.this , "its the add activity", Toast.LENGTH_SHORT).show();
    }
}