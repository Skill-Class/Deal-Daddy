package com.example.dealdaddy.Model;

import java.util.List;

public class ItemsWithImageArrayList {

    private List<ItemForHomeImages> itemForHomeImages;
    private Integer productImage;
    private String companyName;
    private String itemType;
    private String prize;

    boolean Fav;

    public ItemsWithImageArrayList(List<ItemForHomeImages> itemForHomeImages,Integer productImage, String companyName, String itemType, String prize, boolean fav) {
        this.itemForHomeImages = itemForHomeImages;
        this.productImage = productImage;
        this.companyName = companyName;
        this.itemType = itemType;
        this.prize = prize;
        Fav = fav;
    }

    public ItemsWithImageArrayList() {
    }

    public List<ItemForHomeImages> getItemForHomeImages() {
        return itemForHomeImages;
    }

    public Integer getProductImage() {
        return productImage;
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
