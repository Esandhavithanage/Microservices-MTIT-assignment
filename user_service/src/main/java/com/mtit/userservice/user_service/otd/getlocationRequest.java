package com.mtit.userservice.user_service.otd;

public class getlocationRequest {

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
