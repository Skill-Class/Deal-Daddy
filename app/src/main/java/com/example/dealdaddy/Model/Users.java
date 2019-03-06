package com.example.dealdaddy.Model;

public class Users {

    private String userName;
    private String userEmailId;
    private String UserProfilePic;

    public Users(String userName,String userEmailId,String userProfilePic){

        this.userName = userName;
        this.userEmailId = userEmailId;
        UserProfilePic = userProfilePic;

    }

    public Users(){

    }

    private String getUserName(){
        return userName;
    }

    private void setUserName(String userName){
        this.userName = userName;
    }

    private String getUserEmailId(){

        return userEmailId;
    }

    private void setUserEmailId(String userEmailId){

        this.userEmailId = userEmailId;
    }

    private String getUserProfilePic(){

        return UserProfilePic;
    }

    private void setUserProfilePic(String userProfilePic){

        UserProfilePic = userProfilePic;
    }
}
