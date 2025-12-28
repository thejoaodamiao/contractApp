package org.dev.application;


import org.dev.model.enteties.Contract;
import org.dev.model.enteties.Installment;
import org.dev.model.services.ContractService;
import org.dev.model.services.PaypalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre os dados do contrato:");
        System.out.print("Numero: ");
        int num = sc.nextInt();
        System.out.print("Data do contrato: ");
        LocalDate dueDate =  LocalDate.parse(sc.next(), dtf);
        System.out.print("Valor do contrato: ");
        double totalAmount = sc.nextDouble();
        System.out.print("Entre com o numero de parcelas: ");
        int parcelas = sc.nextInt();
        Contract contract = new Contract(num, dueDate, totalAmount);

        ContractService service = new ContractService(new PaypalService());

        service.processContract(contract, parcelas);

        System.out.println();
        System.out.println("Parcelas: ");

        for(Installment i : contract.getInstallments()){
            System.out.println(i.getDueDate().format(dtf) + " - " + String.format("%.2f", i.getAmount()));
        }

    }
}