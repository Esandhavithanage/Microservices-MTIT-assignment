package com.mtit.orderservice.order_service.otd;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class order {
    private String id;
    private Date todate;
    private ArrayList<orderItem> itemlist = new ArrayList<>();
    private double tot;

    public order() {
        id = this.idGenarater();
        todate = new Date();
    }

    public String getId() {
        return id;
    }


    public Date getTodate() {
        return todate;
    }


    public ArrayList<orderItem> getItemlist() {
        return itemlist;
    }

    public void setItemlist(ArrayList<orderItem> itemlist) {
        this.itemlist = itemlist;
    }

    public double getTot() {
        return tot;
    }

    public void setTot(double tot) {
        this.tot = tot;
    }

    public String idGenarater() {
        Date today = new Date();
        Random rand = new Random();
        String id = "O"+today.getYear()+""+rand.nextInt(100);

                return id;
    }

}
