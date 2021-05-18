package com.mtit.itemservice.item_service.controller;

import com.mtit.itemservice.item_service.otd.Item;
import com.mtit.itemservice.item_service.otd.ItemRequest;
import com.mtit.itemservice.item_service.otd.ItemResponse;
import com.mtit.itemservice.item_service.otd.getUserResponse;
import com.mtit.itemservice.item_service.service.userServiceimpl;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("item")
public class ItemController {

    private ArrayList<Item> items = new ArrayList<>();
    private userServiceimpl userServiceimpl = new userServiceimpl();

    @PostMapping(path = "insert",consumes = "application/json",produces = "application/json")
    public @ResponseBody ItemResponse insertItem(@RequestBody ItemRequest req){

        String msg = "";
        ItemResponse itemResponse = new ItemResponse();
        if(this.userStatusChecker(req)){

            System.out.println(" New Item details" + req);

            Item i = new Item();
            i.setId(i.idGenarater());
            i.setName(req.getName());
            i.setDescription(req.getDescription());
            i.setQty(req.getQty());
            i.setSellingPrice(req.getSellingPrice());

            items.add(i);

            itemResponse.setId(i.getId());
            itemResponse.setItems(items);
            msg ="Successfully added item";
        }else {
            msg="you can't accesses this page";
        }

        itemResponse.setMessage(msg);
        return itemResponse;
    }

    @PostMapping(path = "getItemDetailsById",consumes = "application/json",produces = "application/json")
    public @ResponseBody Object getItemDetailsById(@RequestBody ItemRequest req){

        System.out.println(" New Item details" + req);

        Object object = new Object();
        for (int i=0;i<items.size();i++) {

            if(items.get(i).getId().equals(req.getId())){
               object = items.get(i);
            }
        }
        return object;
    }


    @PostMapping(path = "delete",consumes = "application/json",produces = "application/json")
    public @ResponseBody ItemResponse deleteItem(@RequestBody ItemRequest req){

        String msg = "";
        ItemResponse itemResponse = new ItemResponse();
        if(this.userStatusChecker(req)){
            System.out.println(" deleted Item id" + req.getId());


            for (int i=0;i<items.size();i++) {

                if(items.get(i).getId().equals(req.getId())){
                    items.remove(i);
                }
            }

            itemResponse.setId(req.getId());
            itemResponse.setItems(items);
            msg="Successfully deleted";
        }else {
            msg="you can't accesses this page";
        }

        itemResponse.setMessage(msg);
        return itemResponse;
    }

    @PostMapping(path = "update",consumes = "application/json",produces = "application/json")
    public @ResponseBody ItemResponse updateItem(@RequestBody ItemRequest req){

        String msg = "";
        ItemResponse itemResponse = new ItemResponse();
        if(this.userStatusChecker(req)){
            for (int i=0;i<items.size();i++) {
                System.out.println(items.get(i).getId().equals(req.getId()));
                System.out.println(req.getId());
                if(items.get(i).getId().equals(req.getId())){
                    items.get(i).setName(req.getName());
                    items.get(i).setQty(req.getQty());
                    items.get(i).setDescription(req.getDescription());
                    items.get(i).setSellingPrice(req.getSellingPrice());
                }
            }


            itemResponse.setId(req.getId());
            itemResponse.setItems(items);

            msg="Successfully updated";
        }else {
            msg="you can't accesses this page";
        }

        itemResponse.setMessage(msg);
        return itemResponse;
    }

    public boolean userStatusChecker(ItemRequest itemRequest){
        getUserResponse getUserResponse =  userServiceimpl.checkUser(itemRequest);

        return (getUserResponse.isIslogined() == true && getUserResponse.getType().equals("Admin"));
    }
}


