package com.sushant.demo;

import org.springframework.stereotype.Component;

@Component
public class PurchaseService {
    public void purchase(String item){
        System.out.println("you purchase "+item);
    }
}
