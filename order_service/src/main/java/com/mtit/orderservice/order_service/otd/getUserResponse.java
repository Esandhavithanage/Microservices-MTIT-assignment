package com.mtit.orderservice.order_service.otd;

public class getUserResponse {
    private String id;
    private String message;
    private String type;
    private boolean islogined;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isIslogined() {
        return islogined;
    }

    public void setIslogined(boolean islogined) {
        this.islogined = islogined;
    }
}
