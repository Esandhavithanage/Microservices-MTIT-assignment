package com.mtit.orderservice.order_service.otd;

public class orderRequest {
   private String userId;
   private String itemId;
   private int qty;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "orderRequest{" +
                "userId='" + userId + '\'' +
                ", itemId='" + itemId + '\'' +
                ", qty=" + qty +
                '}';
    }
}
