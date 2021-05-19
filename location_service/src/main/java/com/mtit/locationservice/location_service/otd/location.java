package com.mtit.locationservice.location_service.otd;

import java.util.Date;
import java.util.Random;

public class location {
    private String id;
    private String address;

    public location() {
        this.setId(this.idGenarater());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String idGenarater() {
        Date today = new Date();
        Random rand = new Random();
        String id = "L"+today.getYear()+""+rand.nextInt(100);
        return id;
    }

    @Override
    public String toString() {
        return "location{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
