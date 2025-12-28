package org.dev.application;


import org.dev.model.enteties.Contract;
import org.dev.model.services.ContractService;
import org.dev.model.services.PaypalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Entre os dados do contrato:");
        System.out.print("Numero: ");
        int num = sc.nextInt();
        System.out.print("Data do contrato: ");
        Date dueDate = sdf.parse(sc.next());
        System.out.print("Valor do contrato: ");
        double totalAmount = sc.nextDouble();
        System.out.print("Entre com o numero de parcelas: ");
        int parcelas = sc.nextInt();
        Contract contract = new Contract(num, dueDate, totalAmount);

        ContractService service = new ContractService(new PaypalService());

        service.processContract(contract, parcelas);

        System.out.println();
        System.out.println("Parcelas: ");

        for(int i = 0; i <= contract.getInstallments().size(); i++){
            System.out.println(contract.getInstallments().get(i).getDueDate() + " - " +  contract.getInstallments().get(i).getAmount());
        }

    }
}