package com.mtit.orderservice.order_service.otd;

import java.util.ArrayList;

public class orderResponse {
    private String id;
    private String message;
    private order myorder;

    public order getMyorder() {
        return myorder;
    }

    public void setMyorder(order myorder) {
        this.myorder = myorder;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
