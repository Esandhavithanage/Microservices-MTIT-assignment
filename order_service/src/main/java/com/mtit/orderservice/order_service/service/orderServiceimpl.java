package com.mtit.orderservice.order_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.mtit.orderservice.order_service.otd.*;

import javax.xml.ws.Response;


@Service
public class orderServiceimpl {

    private RestTemplate restTemplate = new RestTemplate();

    public getItemResponse createOrder(orderRequest orderRequest){
        getItemRequest itemrequest = new getItemRequest();
        itemrequest.setId(orderRequest.getItemId());
        ResponseEntity<getItemResponse> itemResponse = restTemplate.postForEntity("http://localhost:8080/item/getItemDetailsById",itemrequest,getItemResponse.class);

        return itemResponse.getBody();
    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}
