package com.mtit.userservice.user_service.service;

import com.mtit.userservice.user_service.otd.getlocationRequest;
import com.mtit.userservice.user_service.otd.getlocationResponse;
import com.mtit.userservice.user_service.otd.userRequest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class userServiceimpl {

    private RestTemplate restTemplate = new RestTemplate();

    public getlocationResponse getLocationdetails(userRequest request){
        getlocationRequest locationrequest = new getlocationRequest();
        locationrequest.setAddress(request.getAddress());
        ResponseEntity<getlocationResponse> orderResponse = restTemplate.postForEntity("http://localhost:8085/location/getLocation",locationrequest,getlocationResponse.class);

        return orderResponse.getBody();
    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}
