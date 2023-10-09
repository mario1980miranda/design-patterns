package com.code.truck.design_patterns.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Concrete strategy that implements PayPal payment method
 */
public class PayByPayPal implements PayStrategy {
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    private boolean signedIn;

    static {
        DATA_BASE.put("mariom", "mario.miranda@gmail.com");
        DATA_BASE.put("qwerty", "john@amazon.eu");
    }

    public void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }

    /**
     * Save customer data for future shopping attempts.
     */
    @Override
    public boolean pay(int paymentAmount) {
        if (signedIn) {
            System.out.println("Paying " + paymentAmount + " using PayPal.");
            return true;
        }
        return false;
    }

    /**
     * Collect customers data
     */
    @Override
    public void collectPaymentDetails() {
        try {
            while (!signedIn) {
                System.out.println("Enter user`s email: ");
                email = READER.readLine();
                System.out.println("Enter user`s password: ");
                password = READER.readLine();
                if (verify()) {
                    System.out.println("Data verification has been successful");
                } else {
                    System.out.println("Wrong email or password");
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private boolean verify() {
        setSignedIn(email.equals(DATA_BASE.get(password)));
        return signedIn;
    }

}
