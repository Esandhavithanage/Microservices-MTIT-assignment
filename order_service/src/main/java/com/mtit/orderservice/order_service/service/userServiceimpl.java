package com.mtit.orderservice.order_service.service;

import com.mtit.orderservice.order_service.otd.*;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class userServiceimpl {

    private RestTemplate restTemplateuser = new RestTemplate();

    public getUserResponse checkUser(orderRequest orderRequest){
        getUserRequest getUserRequest = new getUserRequest();
        getUserRequest.setId(orderRequest.getUserId());
        ResponseEntity<getUserResponse> getUserResponseResponseEntity = restTemplateuser.postForEntity("http://localhost:8083/user/getUserstatus",getUserRequest,getUserResponse.class);

        return getUserResponseResponseEntity.getBody();
    }
    @Bean
    public RestTemplate restTemplate1(RestTemplateBuilder builder){
        return builder.build();
    }
}
