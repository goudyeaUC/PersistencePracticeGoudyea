package com.elkabani.firstspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service
public class OrderService {
    private PaymentService paymentService;
    //public OrderService(){}

  //@Autowired
    public OrderService( PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    public void placeOrder(){
      //  var paymentService = new PaypalPaymentService();
        paymentService.processPayment(100);
    }
}
