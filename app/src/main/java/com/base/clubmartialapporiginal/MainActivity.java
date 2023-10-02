package com.base.clubmartialapporiginal;

import static android.graphics.Color.RED;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import com.base.clubmartialapporiginal.model.DatabaseHandler;
import com.base.clubmartialapporiginal.model.MartialArt;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import java.text.NumberFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {

    private DatabaseHandler databaseHandler;
    private double totalMartialArtsPrice;

    private ScrollView scrollView;

    private int materialArtButtonwidth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        databaseHandler = new DatabaseHandler(MainActivity.this);
        totalMartialArtsPrice = 0.0;
        scrollView = (ScrollView) findViewById(R.id.scrollView);

        Point screenSize = new Point();
        getWindowManager().getDefaultDisplay().getSize(screenSize);
        materialArtButtonwidth = screenSize.x/2;


        modifyUserInterface();


    }

   private void modifyUserInterface(){


       ArrayList<MartialArt> allMartialArtObjects =
               databaseHandler.returnAllMartialArtObject();

       scrollView.removeAllViewsInLayout();



       if(allMartialArtObjects.size()> 0){

           GridLayout gridLayout = new GridLayout(MainActivity.this);
           gridLayout.setRowCount((allMartialArtObjects.size() + 1)/ 2) ;

           gridLayout.setColumnCount(2);

           MartialArtButton[] martialArtButton =
                   new MartialArtButton[allMartialArtObjects.size()];

           int index = 0;
            for(MartialArt martialArtObject : allMartialArtObjects){

                martialArtButton[index] = new MartialArtButton(MainActivity.this , martialArtObject);

                martialArtButton[index].setText(martialArtObject.getMartialArtID() + "\n" +
                        martialArtObject.getMartialArtname() + "\n"  +
                        martialArtObject.getMartialArtPrice());

                switch (martialArtObject.getMartialArtColor()){
                    case"Red":
                        martialArtButton[index].setBackgroundColor(Color.RED);
                        break;

                    case"Blue":
                        martialArtButton[index].setBackgroundColor(Color.BLUE);
                        break;

                    case"Black":
                        martialArtButton[index].setBackgroundColor(Color.BLACK);
                        break;
                    case"Yellow":
                        martialArtButton[index].setBackgroundColor(Color.YELLOW);
                        break;
                    case"Purple":
                        martialArtButton[index].setBackgroundColor(Color.CYAN);
                        break;

                    case"Green":
                        martialArtButton[index].setBackgroundColor(Color.GREEN);
                        break;

                    case"White":
                        martialArtButton[index].setBackgroundColor(Color.WHITE);
                        break;

                    default:
                        martialArtButton[index].setBackgroundColor(Color.GRAY);
                        break;

                }
                martialArtButton[index].setOnClickListener(MainActivity.this);
                gridLayout.addView(martialArtButton[index],
                        materialArtButtonwidth, ViewGroup.LayoutParams.WRAP_CONTENT);

            }

           scrollView.addView(gridLayout);

       }

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
            Intent deleteMartialArtDeleteIntent = new Intent(MainActivity.this,
                                                            DeleteMartialArtActivity.class);
            startActivity(deleteMartialArtDeleteIntent);
        }

        if(id == R.id.update_martial_art){
            Intent updateMartialArtIntent = new Intent(MainActivity.this,
                                                    UpdateMartialArtActivity.class);
            startActivity(updateMartialArtIntent);
        }

        if(id == R.id.martial_art_prices_reset){
            totalMartialArtsPrice = 0.0;

            Toast.makeText(this, "the Prices are Reset", Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view) {

        MartialArtButton martialArtButton = (MartialArtButton) view;
        totalMartialArtsPrice = totalMartialArtsPrice + martialArtButton
                .getMartialArtPrice();
        String martialArtsPriceFormatted = NumberFormat.getCurrencyInstance()
                .format(totalMartialArtsPrice);
        Toast.makeText(MainActivity.this, martialArtsPriceFormatted,
                Toast.LENGTH_SHORT).show();



    }

    @Override
    protected void onResume() {
        super.onResume();
         modifyUserInterface();
    }
}