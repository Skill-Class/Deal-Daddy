package com.example.dealdaddy.Model;

public class Slide {

    private Integer Image ;
    private String Title;


    public Slide(Integer image, String title) {
        Image = image;
        Title = title;
    }


    public Integer getImage() {
        return Image;
    }

    public String getTitle() {
        return Title;
    }

    public void setImage(Integer image) {
        Image = image;
    }

    public void setTitle(String title) {
        Title = title;
    }
}