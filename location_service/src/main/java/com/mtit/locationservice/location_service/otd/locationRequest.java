package com.mtit.locationservice.location_service.otd;

public class locationRequest {

    private String address;


    @Override
    public String toString() {
        return "locationRequest{" +
                "address='" + address + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
