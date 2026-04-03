package com.springAgain.rev.springrevision;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDependencyInjectionMain implements CommandLineRunner {



    public static void main(String[] args) {
		SpringApplication.run(SpringDependencyInjectionMain.class, args);
	}

//    RayzorPaymentService paymentService = new RayzorPaymentService();

//    @Autowired
//    private RayzorPaymentService paymentService;  //Field injection --> not recommend to use



    private final PaymentService paymentservice; // constructor is preferred because we can use final in it which cant be changed. in field injection you cant use final

//    -----------------------constructor dependency injection------------------ -> best way to use Dependency injection (DI)

    public SpringDependencyInjectionMain(PaymentService paymentservice) {
        this.paymentservice = paymentservice;   //constructor ///DI //preferred
    }



    @Override
    public void run(String... args) throws Exception {
           String payment = paymentservice.pay();
        System.out.println(payment);
    }
}
