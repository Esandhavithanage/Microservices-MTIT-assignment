package com.mtit.locationservice.location_service.controller;

import com.mtit.locationservice.location_service.otd.location;
import com.mtit.locationservice.location_service.otd.locationRequest;
import com.mtit.locationservice.location_service.otd.locationResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("location")
public class LocationController {

    private location locations = new location();


    @PostMapping(path = "getLocation", consumes = "application/json", produces = "application/json")
    public @ResponseBody locationResponse register(@RequestBody locationRequest req) {

        System.out.println(" New user details" + req);

        locations.setAddress(req.getAddress());


        locationResponse response = new locationResponse();
        response.setId(locations.getId());
        response.setMessage("location successfully saved");
        return response;
    }
}
