package com.mtit.paymentservice.payment_service.otd;

public class getOrderResponse {
    private String id;
    private String message;
    private Object myorder;

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

    public Object getMyorder() {
        return myorder;
    }

    public void setMyorder(Object myorder) {
        this.myorder = myorder;
    }
}
