package com.mtit.userservice.user_service.controller;

import com.mtit.userservice.user_service.otd.user;
import com.mtit.userservice.user_service.otd.userRequest;
import com.mtit.userservice.user_service.otd.userResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("user")
public class UserController {

    private ArrayList<user> userArrayList = new ArrayList<>();

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
        response.setMessage("successfully registered");
        return response;
    }

    @PostMapping(path = "login", consumes = "application/json", produces = "application/json")
    public @ResponseBody userResponse login(@RequestBody userRequest req) {

        System.out.println(" Login details" + req);

        userResponse response = new userResponse();

        for (int i=0;i<userArrayList.size();i++) {
            System.out.println(userArrayList.get(i).toString());

            if(userArrayList.get(i).getUsername().equals(req.getUsername()) && userArrayList.get(i).getPassword().equals(req.getPassword())){
                userArrayList.get(i).setIslogined(true);
                response.setId(userArrayList.get(i).getId());
                response.setType(userArrayList.get(i).getType());
                response.setIslogined(userArrayList.get(i).isIslogined());
                response.setMessage("successfully login");
                break;
            }
            else {
                response.setId(null);
                response.setMessage("plese check user name and password");
            }
        }
        return response;
    }

    @PostMapping(path = "logout", consumes = "application/json", produces = "application/json")
    public @ResponseBody userResponse logout(@RequestBody userRequest req) {

        System.out.println(" Login details" + req);


        for (int i=0;i<userArrayList.size();i++) {

            if(userArrayList.get(i).getId().equals(req.getId())){
                userArrayList.get(i).setIslogined(false);

            }

        }

        userResponse response = new userResponse();
        response.setId(null);
        response.setMessage("successfully logout");
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
