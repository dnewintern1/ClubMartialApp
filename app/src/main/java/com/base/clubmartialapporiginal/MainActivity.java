package com.base.clubmartialapporiginal;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;


import com.base.clubmartialapporiginal.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {




    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        int id = item.getItemId();


        if( id == R.id.add_martial_art) {
            Intent addMartialArtIntent = new Intent(MainActivity.this ,
                    Add_Martial_Art.class);
            startActivity(addMartialArtIntent);

        }
        if(id == R.id.delete_martial_art){
            Intent deleteMartialArtDeleteIntent = new Intent(MainActivity.this, DeleteMartialArtActivity.class);
            startActivity(deleteMartialArtDeleteIntent);
        }


        return super.onOptionsItemSelected(item);
    }


}