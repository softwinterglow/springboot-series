package com.springAgain.rev.springrevision;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary  // Payment method will use this as a primary instead od Razorpay because this is primary.. if both component are in use spring will use primary one
@Component
public class StripePaymentService implements PaymentService{
    @Override
    public String pay() {
        String Payment ="Stripe Payment";
        System.out.println("Payment from :" + Payment);
        return Payment;
    }
}
