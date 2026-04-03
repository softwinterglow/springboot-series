package com.sushant.demo.IMPL;

import com.sushant.demo.NotificationService;

public class EmailNotificationService implements NotificationService {
    public void send(String message){
        System.out.println("email sending: "+message);
    }
}
