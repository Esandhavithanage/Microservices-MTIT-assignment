package com.mtit.itemservice.item_service.otd;

import java.util.Date;
import java.util.Random;

public class Item {
    private String id;
    private String name;
    private String description;
    private int qty;
    private double sellingPrice;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }


    public String idGenarater() {
        Date today = new Date();
        Random rand = new Random();
        String id = today.getYear()+""+rand.nextInt(100);

                return id;
    }

}
