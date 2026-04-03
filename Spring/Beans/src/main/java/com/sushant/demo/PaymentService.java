package com.sushant.demo;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;


//Why do we need @Component, @Service, etc.?
//Spring needs to know:
//        “Which classes should I create objects (beans) for?”
//Because Spring does not automatically create objects for every class.
//        👉 If you don’t tell Spring, your class is just a normal Java class.
@Component
public class PaymentService {

        public void pay(){
            System.out.println("paying.....");

    }

    @PostConstruct
    public void afterInitaaa(){
        System.out.println("before payingggg");
    }

    @PreDestroy
    public void afterPaying(){
        System.out.println("After payment is done");
    }


}
