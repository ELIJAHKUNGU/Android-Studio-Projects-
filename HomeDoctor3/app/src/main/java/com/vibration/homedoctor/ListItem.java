package com.vibration.homedoctor;

public class ListItem {
    private String mainservice;
    private String serviceone;
    private String Servicetwo;
    private String Servicethree;
    private String moredetails;
    private  String Image;

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    private ListItem() {

    }

    public String getMainservice() {
        return mainservice;
    }

    public void setMainservice(String mainservice) {
        this.mainservice = mainservice;
    }

    public String getServiceone() {
        return serviceone;
    }

    public void setServiceone(String serviceone) {
        this.serviceone = serviceone;
    }

    public String getServicetwo() {
        return Servicetwo;
    }

    public void setServicetwo(String servicetwo) {
        Servicetwo = servicetwo;
    }

    public String getServicethree() {
        return Servicethree;
    }

    public void setServicethree(String servicethree) {
        Servicethree = servicethree;
    }

    public String getMoredetails() {
        return moredetails;
    }

    public void setMoredetails(String moredetails) {
        this.moredetails = moredetails;
    }
}





