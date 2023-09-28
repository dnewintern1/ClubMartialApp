package com.base.clubmartialapporiginal.model;

public class MartialArt {

    private  String martialArtname;
    private  String martialArtColor;
    private  int martialArtID;
    private double martialArtPrice;


    public MartialArt(int id, String color, double price, String name) {
        setMartialArtID(id);
        setMartialArtname(name);
        setMartialArtColor(color);
        setMartialArtPrice(price);
    }

    public String getMartialArtname() {
        return martialArtname;
    }

    public void setMartialArtname(String martialArtname) {
        this.martialArtname = martialArtname;
    }

    public String getMartialArtColor() {
        return martialArtColor;
    }

    public void setMartialArtColor(String martialArtColor) {
        this.martialArtColor = martialArtColor;
    }

    public int getMartialArtID() {
        return martialArtID;
    }

    public void setMartialArtID(int martialArtID) {
        this.martialArtID = martialArtID;
    }

    public double getMartialArtPrice() {
        return martialArtPrice;
    }

    public void setMartialArtPrice(double martialArtPrice) {
        this.martialArtPrice = martialArtPrice;
    }
}