package com.sushant.demo.IMPL;

import com.sushant.demo.NotificationService;

public class SmsNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("message sending: "+message);
    }
}
