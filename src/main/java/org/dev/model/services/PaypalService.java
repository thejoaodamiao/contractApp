package org.dev.model.services;

public class PaypalService implements OnlinePaymentService {


    @Override
    public Double paymentFee(Double amount) {
        return 0.0;
    }

    @Override
    public Double interest(Double amount, Integer months) {
        return 0.0;
    }
}
