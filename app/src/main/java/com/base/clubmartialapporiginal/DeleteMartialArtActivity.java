package com.base.clubmartialapporiginal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.base.clubmartialapporiginal.model.DatabaseHandler;
import com.base.clubmartialapporiginal.model.MartialArt;

import java.util.ArrayList;

public class DeleteMartialArtActivity extends AppCompatActivity  implements RadioGroup.OnCheckedChangeListener, View.OnClickListener{

    private DatabaseHandler databaseHandler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_martial_art);

        databaseHandler = new DatabaseHandler(DeleteMartialArtActivity.this);


        updateTheUserInterface();
    }

    private void updateTheUserInterface(){
        ArrayList<MartialArt> allMartialArtObject =
                databaseHandler.returnAllMartialArtObject();

        RelativeLayout relativeLayout = new RelativeLayout(DeleteMartialArtActivity.this);

        ScrollView scrollView = new ScrollView(DeleteMartialArtActivity.this);

        RadioGroup radioGroup = new RadioGroup(DeleteMartialArtActivity.this);

        for(MartialArt martialArt : allMartialArtObject){

            RadioButton currentRadioButton = new RadioButton(DeleteMartialArtActivity.this);
            currentRadioButton.setId(martialArt.getMartialArtID());
            currentRadioButton.setText(martialArt.toString());
            radioGroup.addView(currentRadioButton);
        }

        radioGroup.setOnCheckedChangeListener(DeleteMartialArtActivity.this);

        Button btnback = new Button(DeleteMartialArtActivity.this);
        btnback.setText("go back");
        btnback.setOnClickListener(DeleteMartialArtActivity.this);

        scrollView.addView(radioGroup);

        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.setMargins(0,0,0,70);

        relativeLayout.addView(btnback, buttonParams);
        ViewGroup.LayoutParams scrollViewParams = new ViewGroup.LayoutParams(
                ScrollView.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );

        relativeLayout.addView(scrollView,scrollViewParams);

        setContentView(relativeLayout);




    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        databaseHandler.deleteMartialArtObjectFromDatabaseById(checkedId);
        updateTheUserInterface();
        Toast.makeText(DeleteMartialArtActivity.this , "the martial art object is deleted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}