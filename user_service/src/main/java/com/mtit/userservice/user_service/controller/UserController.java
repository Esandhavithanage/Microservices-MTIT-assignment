package com.mtit.userservice.user_service.controller;

import com.mtit.userservice.user_service.otd.getlocationResponse;
import com.mtit.userservice.user_service.otd.user;
import com.mtit.userservice.user_service.otd.userRequest;
import com.mtit.userservice.user_service.otd.userResponse;
import com.mtit.userservice.user_service.service.userServiceimpl;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("user")
public class UserController {

    private ArrayList<user> userArrayList = new ArrayList<>();
    private userServiceimpl userServiceimplobj = new userServiceimpl();

    public UserController() {
        user admin = new user();
        admin.setType("Admin");
        admin.setUsername("admin");
        admin.setPassword("123");
        userArrayList.add(admin);
    }


    @PostMapping(path = "register", consumes = "application/json", produces = "application/json")
    public @ResponseBody userResponse register(@RequestBody userRequest req) {

        System.out.println(" New user details" + req);

      getlocationResponse getlocationResponseobj =  userServiceimplobj.getLocationdetails(req);

        user newUser = new user();
        newUser.setName(req.getName());
        newUser.setDob(req.getDob());
        newUser.setNIC(req.getNIC());
        newUser.setAddress(req.getAddress());
        newUser.setType("customer");
        newUser.setUsername(req.getUsername());

        newUser.setPassword(req.getPassword());
        newUser.setIslogined(false);
        userArrayList.add(newUser);
        System.out.println(userArrayList.toString());

        userResponse response = new userResponse();
        response.setId(newUser.getId());
        response.setLocationid(getlocationResponseobj.getId());
        response.setMessage("successfully registered");
        return response;
    }


    @PostMapping(path = "getUserstatus", consumes = "application/json", produces = "application/json")
    public @ResponseBody userResponse getUserstatus(@RequestBody userRequest req) {

        System.out.println(" Login details" + req);

        user cusentUser = new user();

        for (int i=0;i<userArrayList.size();i++) {

            if(userArrayList.get(i).getId().equals(req.getId())){
                cusentUser = userArrayList.get(i);

            }

        }

        userResponse response = new userResponse();
        response.setId(cusentUser.getId());
        response.setIslogined(cusentUser.isIslogined());
        response.setType(cusentUser.getType());
        response.setMessage("request successfully");
        return response;
    }
}
