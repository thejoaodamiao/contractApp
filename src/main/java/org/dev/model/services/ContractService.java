package org.dev.model.services;

import org.dev.model.enteties.Contract;
import org.dev.model.enteties.Installment;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class ContractService {

    OnlinePaymentService paymentService;


    public ContractService(OnlinePaymentService paymentService)
    {
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, Integer months){

        Calendar calendar = Calendar.getInstance();


        double amount = contract.getTotalValue()/months;

        for (int i = 1; i < months; i++) {

            double interest = paymentService.interest(amount,i);
            double paymentFee = paymentService.paymentFee(amount);

            calendar.setTime(contract.getDate());
            calendar.add(Calendar.MONTH, i);
            Date dueDate = calendar.getTime();
            contract.addInstallment(new Installment(dueDate, amount + interest + paymentFee ));


        }

    }

}
