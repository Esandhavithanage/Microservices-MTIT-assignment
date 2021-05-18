package com.mtit.paymentservice.payment_service.otd;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class payment {
    private String id;
    private String paymentType;
    private String cardType;
    private String cardNumber;
    private String vcc;
    private String expirationDate;

    public payment() {
        id = this.idGenarater();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getVcc() {
        return vcc;
    }

    public void setVcc(String vcc) {
        this.vcc = vcc;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String idGenarater() {
        Date today = new Date();
        Random rand = new Random();
        String id = "P"+today.getYear()+""+rand.nextInt(100);
                return id;
    }

}
