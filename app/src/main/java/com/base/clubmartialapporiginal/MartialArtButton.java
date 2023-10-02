package com.base.clubmartialapporiginal;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.base.clubmartialapporiginal.model.MartialArt;

public class MartialArtButton extends AppCompatButton {

    private int martialArtButtonWidth;

    private MartialArt martialArtObject;

    public MartialArtButton(Context context, MartialArt martialArt){

        super(context);

        martialArtObject = martialArt;
    }
    public String getMartialArtColor(){
        return martialArtObject.getMartialArtColor();

    }

    public double getMartialArtPrice(){
        return  martialArtObject.getMartialArtPrice();
    }


}
