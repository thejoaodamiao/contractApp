package org.dev.model.services;

public class PaypalService implements OnlinePaymentService {


    @Override
    public Double paymentFee(Double amount) {
        return amount * 0.02;
    }

    @Override
    public Double interest(Double amount, Integer months) {
        double interest =  amount * 0.01;

        return interest * months ;
    }
}
