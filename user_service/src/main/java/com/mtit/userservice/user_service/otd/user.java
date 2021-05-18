package com.mtit.userservice.user_service.otd;

import java.util.Date;
import java.util.Random;

public class user {
    private String id;
    private String name;
    private String dob;
    private String NIC;
    private String address;
    private String type;
    private String password;
    private String username;
    private boolean islogined;

    public boolean isIslogined() {
        return islogined;
    }

    public void setIslogined(boolean islogined) {
        this.islogined = islogined;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public user() {
        this.id = this.idGenarater();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
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
        String id = "U"+today.getYear()+""+rand.nextInt(100);
        return id;
    }

    @Override
    public String toString() {
        return "user{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", NIC='" + NIC + '\'' +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", islogined=" + islogined +
                '}';
    }
}
