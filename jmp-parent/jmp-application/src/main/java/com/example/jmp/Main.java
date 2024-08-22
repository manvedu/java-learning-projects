package com.example.jmp.application;

import com.example.jmp.bank.api.Bank;
import com.example.jmp.cloud.bank.impl.BankCreator;
import com.example.jmp.cloud.bank.impl.BankType;
import com.example.jmp.dto.BankCard;
import com.example.jmp.dto.BankCardType;
import com.example.jmp.dto.Subscription;
import com.example.jmp.dto.User;
import com.example.jmp.service.api.Service;
import com.example.jmp.cloud.service.impl.ServiceImplementation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // Create a user
        var user = new User("John", "Wick", LocalDate.of(2000, 1, 1));

        // Create a bank
        Bank bank = BankCreator.createBank(BankType.RETAIL_BANK);

        // Create a bank card for the user
        BankCard bankCard = bank.createBankCard(user, BankCardType.CREDIT);
        /*
        //var tarjeta = new CreditBankCard()

        // Create a service instance
        Service service = new ServiceImplementation();

        // Subscribe the user using the bank card
        service.subscribe(bankCard);

        // Retrieve the subscription by bank card number
        Optional<Subscription> subscription = service.getSubscriptionByBankCardNumber(bankCard.getNumber());



        // Print all users in the system
        System.out.println("All Users:");
        service.getAllUsers().forEach(System.out::println);
        */


        // To implement method with predicate
        var s1 = new Subscription("bankcardnumber1", LocalDate.now());
        var s2 = new Subscription("bankcardnumber2", LocalDate.now().minusDays(2));
        var s3 = new Subscription("bankcardnumber3", LocalDate.now().minusDays(5));

        // get subscriptions newer than 3 days ago
        Predicate<Subscription> condition = sub -> sub.getStartDate().isBefore(LocalDate.now().minusDays(3));

        // Get subscriptions by condition
        Service service = new ServiceImplementation();
        List<Subscription> filteredSubscriptions = service.getAllSubscriptionsByCondition(condition);
        //I'd like to add testing for this

    }
}