package com.mtit.orderservice.order_service.controller;


import com.mtit.orderservice.order_service.otd.*;
import com.mtit.orderservice.order_service.service.orderServiceimpl;
import com.mtit.orderservice.order_service.service.userServiceimpl;
import jdk.nashorn.api.scripting.AbstractJSObject;
import jdk.nashorn.api.scripting.JSObject;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;


@RestController
@RequestMapping("order")
public class OrderController {

    private orderServiceimpl orderServiceimpls = new orderServiceimpl();
    private userServiceimpl userServiceimpl = new userServiceimpl();
    private order myOrder = new order();

    @PostMapping(path = "addItemToOrder", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    orderResponse addItemToOrder(@RequestBody orderRequest req) {
        String msg = "";
        orderResponse response = new orderResponse();

        if (this.userStatusChecker(req)){
            System.out.println(" New Order details" + req);
            getItemResponse itemdetails = orderServiceimpls.createOrder(req);
            ArrayList<orderItem> itemList = myOrder.getItemlist();

            double amount = itemdetails.getSellingPrice() * req.getQty();

            orderItem item = new orderItem();
            item.setId(itemdetails.getId());
            item.setName(itemdetails.getName());
            item.setPrice(itemdetails.getSellingPrice());
            item.setQty( req.getQty());
            item.setAmount(amount);

            itemList.add(item);

            myOrder.setTot(myOrder.getTot() + amount);

            myOrder.setItemlist(itemList);
            msg ="Added item successfully";
            response.setId(myOrder.getId());
            response.setMyorder(myOrder);
        }
        else {
            msg="you can't accesses this page";
        }



        response.setMessage(msg);
        return response;
    }


    @PostMapping(path = "getOrder",consumes = "application/json",produces = "application/json")
    public @ResponseBody orderResponse getOrder(@RequestBody orderRequest req){


        orderResponse response = new orderResponse();
        response.setId(myOrder.getId());
        response.setMyorder(myOrder);
        response.setMessage("Successfully get order");
        return response;
    }

    public boolean userStatusChecker(orderRequest orderRequest){
       getUserResponse getUserResponse =  userServiceimpl.checkUser(orderRequest);

       return (getUserResponse.getType().equals("customer"));
    }
}


