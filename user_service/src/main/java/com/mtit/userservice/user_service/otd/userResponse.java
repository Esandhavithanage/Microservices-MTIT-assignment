package com.mtit.userservice.user_service.otd;

public class userResponse {
    private String id;
    private String locationid;
    private String message;
    private String type;
    private boolean islogined;

    public String getLocationid() {
        return locationid;
    }

    public void setLocationid(String locationid) {
        this.locationid = locationid;
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
