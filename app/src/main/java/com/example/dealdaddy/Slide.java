package com.example.dealdaddy;

public class Slide {

    private String Image ;
    private String Title;
    // Add more field depand on whay you wa&nt ...


    public Slide(String image, String title) {
        Image = image;
        Title = title;
    }


    public String getImage() {
        return Image;
    }

    public String getTitle() {
        return Title;
    }

    public void setImage(String image) {
        Image = image;
    }

    public void setTitle(String title) {
        Title = title;
    }
}