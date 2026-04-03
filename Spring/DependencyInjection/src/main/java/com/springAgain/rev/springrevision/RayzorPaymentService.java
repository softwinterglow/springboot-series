package com.springAgain.rev.springrevision;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

//----------you can use any of the annotation to create spring bean----------------

//@Component
@Service
//@Repository
//@RestController
//@Controller
public class RayzorPaymentService implements PaymentService{

    @Override
    public String pay(){
        String payment = "Razor pay";
        System.out.println("Payment from : "+payment);
        return payment;
    }
}
