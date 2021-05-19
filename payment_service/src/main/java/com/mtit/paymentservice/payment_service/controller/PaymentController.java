package com.mtit.paymentservice.payment_service.controller;

import com.mtit.paymentservice.payment_service.otd.getOrderResponse;
import com.mtit.paymentservice.payment_service.otd.payment;
import com.mtit.paymentservice.payment_service.otd.paymentRequest;
import com.mtit.paymentservice.payment_service.otd.paymentResponse;
import com.mtit.paymentservice.payment_service.service.PaymentServiceimpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment")
public class PaymentController {

    private payment payments = new payment();
    private PaymentServiceimpl paymentServiceimpl = new PaymentServiceimpl();

    @PostMapping(path = "addpayment", consumes = "application/json", produces = "application/json")
    public @ResponseBody paymentResponse addpayment(@RequestBody paymentRequest req) {

        System.out.println(" New payment details" + req);

        getOrderResponse itemdetails = paymentServiceimpl.createOrder();

        paymentResponse response = new paymentResponse();
        response.setId(payments.getId());
        response.setOrder(itemdetails.getMyorder());
        response.setMessage("successfully");
        return response;
    }
}
