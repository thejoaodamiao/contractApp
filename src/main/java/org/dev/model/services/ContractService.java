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




        double amount = contract.getTotalValue()/months;

        for (int i = 1; i <= months; i++) {

            double interest = paymentService.interest(amount,i);
            double paymentFee = paymentService.paymentFee(amount +  interest );
            LocalDate dueDate = contract.getDate().plusMonths(i);


            contract.addInstallment(new Installment(dueDate, amount + interest + paymentFee ));


        }

    }

}
