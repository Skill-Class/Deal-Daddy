package com.example.dealdaddy.Model;

public class ItemForHomeImages {

    private Integer menImage;
    private Integer womenImage;
    private Integer kidsImage;
    private Integer furnitureImage;


    public ItemForHomeImages(Integer menImage, Integer womenImage, Integer kidsImage, Integer furnitureImage) {
        this.menImage = menImage;
        this.womenImage = womenImage;
        this.kidsImage = kidsImage;
        this.furnitureImage = furnitureImage;
    }

    public ItemForHomeImages() {
    }

    public Integer getMenImage() {
        return menImage;
    }

    public Integer getWomenImage() {
        return womenImage;
    }

    public Integer getKidsImage() {
        return kidsImage;
    }

    public Integer getFurnitureImage() {
        return furnitureImage;
    }
}
