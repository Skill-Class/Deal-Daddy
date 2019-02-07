package com.example.dealdaddy.Model;

import android.graphics.drawable.Drawable;



/*
      @author - Sheetal Kumar
 */


public class Items {

    private String companyName;
    private String itemType;
    private String prize;

    boolean Fav;

    public Items(String companyName, String itemType, String prize, boolean fav) {

        this.companyName = companyName;
        this.itemType = itemType;
        this.prize = prize;
        Fav = fav;
    }

    public Items() {
    }


    public String getCompanyName() {
        return companyName;
    }

    public String getItemType() {
        return itemType;
    }

    public String getPrize() {
        return prize;
    }

    public boolean isFav() {
        return Fav;
    }
}
