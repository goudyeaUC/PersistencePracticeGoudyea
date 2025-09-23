package com.elkabani.firstspringboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;
//@Service("stripe")
//@Primary
public class StripePaymentService  implements PaymentService {
    @Value("${stripe.apiUrl}")
    private String apiUrl;
    @Value("${stripe.enabled}")
    private boolean enabled;
    @Value("${stripe.timeout:3000}")
    private int timeout;
    @Value("${stripe.supported-currencies}")
    private List<String> supportedCurrencies;

    @Override
    public void processPayment(double amount){
        System.out.println("Stripe payment" );
        System.out.println("Amount: " + amount);
        System.out.println("Stripe API URL: " + apiUrl);
        System.out.println("Stripe Enabled: " + enabled);
        System.out.println("Stripe Timeout: " + timeout);
        System.out.println("Supported Currencies: " + supportedCurrencies);
    }
}
