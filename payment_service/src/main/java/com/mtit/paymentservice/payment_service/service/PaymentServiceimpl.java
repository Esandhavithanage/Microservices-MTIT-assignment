package com.mtit.paymentservice.payment_service.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import com.mtit.paymentservice.payment_service.otd.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class PaymentServiceimpl {

    private RestTemplate restTemplate = new RestTemplate();

    public getOrderResponse createOrder(){
        getOrderRequest orderrequest = new getOrderRequest();
        ResponseEntity<getOrderResponse> orderResponse = restTemplate.postForEntity("http://localhost:8081/order/getOrder",orderrequest,getOrderResponse.class);

        return orderResponse.getBody();
    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}
