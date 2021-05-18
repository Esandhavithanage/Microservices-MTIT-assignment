package com.mtit.itemservice.item_service.service;

import com.mtit.itemservice.item_service.otd.ItemRequest;
import com.mtit.itemservice.item_service.otd.getUserRequest;
import com.mtit.itemservice.item_service.otd.getUserResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class userServiceimpl {

    private RestTemplate restTemplateuser1 = new RestTemplate();

    public getUserResponse checkUser(ItemRequest itemRequest){
        System.out.println(itemRequest.toString());
        getUserRequest getUserRequests = new getUserRequest();
        getUserRequests.setId(itemRequest.getUserId());
        ResponseEntity<getUserResponse> getUserResponseResponseEntity = restTemplateuser1.postForEntity("http://localhost:8083/user/getUserstatus",getUserRequests,getUserResponse.class);
        System.out.println(getUserResponseResponseEntity.getBody());
        return getUserResponseResponseEntity.getBody();
    }
    @Bean
    public RestTemplate restTemplate2(RestTemplateBuilder builder){
        return builder.build();
    }
}
