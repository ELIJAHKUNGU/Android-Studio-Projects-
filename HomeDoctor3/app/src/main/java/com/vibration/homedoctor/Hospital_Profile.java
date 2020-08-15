package com.vibration.homedoctor;

public class Hospital_Profile {
    private String user;
    private String HosiID;

    private String Email;
    private String PhoneNo;
    private String location;
    private String Image;

    public Hospital_Profile(String user, String hosiID, String email, String phoneNo, String location, String image, String more) {
        this.user = user;
        HosiID = hosiID;
        Email = email;
        PhoneNo = phoneNo;
        this.location = location;
        Image = image;
        this.more = more;
    }

    private String more;



    public Hospital_Profile() {

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getHosiID() {
        return HosiID;
    }

    public void setHosiID(String hosiID) {
        HosiID = hosiID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }
}
