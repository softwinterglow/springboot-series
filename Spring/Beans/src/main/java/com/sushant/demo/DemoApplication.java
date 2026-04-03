package com.sushant.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication   //starts everything
public class DemoApplication implements CommandLineRunner {//CommandLineRunner ->runs code after startup
    @Autowired   //injects  object
    PaymentService paymentService;

    @Autowired
    PurchaseService purchaseservice;




	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

//        ➡️ Spring Boot internally:
//        starts the app
//        creates beans
//        then calls your run() method automatically

    }

    @Override
    public void run(String... args) throws Exception {
        paymentService.pay();
        purchaseservice.purchase("tshirt");




    }
}


