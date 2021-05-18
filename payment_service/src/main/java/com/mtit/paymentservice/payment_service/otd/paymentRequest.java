package com.mtit.paymentservice.payment_service.otd;

public class paymentRequest {
    private String paymentType;
    private String cardType;
    private String cardNumber;
    private String vcc;
    private String expirationDate;

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

    @Override
    public String toString() {
        return "paymentRequest{" +
                "paymentType='" + paymentType + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", vcc='" + vcc + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }
}
