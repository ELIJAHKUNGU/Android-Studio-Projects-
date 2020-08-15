package com.vibration.homedoctor;

public class AddService {
    String mainservice;
    String serviceone;
    String servicetwo;
    String servicethree;
    String moredetails;
    String id;

    public AddService(){

    }

    public AddService(String mainservice,String id, String serviceone, String servicetwo, String servicethree, String moredetails) {
        this.mainservice = mainservice;
        this.serviceone = serviceone;
        this.servicetwo = servicetwo;
        this.servicethree = servicethree;
        this.moredetails = moredetails;
        this.id = id;
    }

    public String getMainservice() {
        return mainservice;
    }

    public String getServiceone() {
        return serviceone;
    }

    public String getServicetwo() {
        return servicetwo;
    }

    public String getServicethree() {
        return servicethree;
    }

    public String getMoredetails() {
        return moredetails;
    }
    public String getId() {
        return id ;
    }
}

