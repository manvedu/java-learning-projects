package com.example.jmp.cloud.service.impl;

import com.example.jmp.dto.*;
import com.example.jmp.service.api.Service; //Not sure

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ServiceImplementation implements Service {

    private final List<Subscription> subscriptions = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    public void subscribe(BankCard bankCard) {
        var subscription = new Subscription(bankCard.getNumber(), LocalDate.now());
        subscriptions.add(subscription);
    }

    public Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber) {
        return subscriptions.stream()
                .filter(subscription -> subscription.getBankcardNumber().equals(bankCardNumber))
                .findFirst();
    }
    @Override
    public List<User> getAllUsers() {
        return users.stream()
                .collect(Collectors.toList());
    }
    @Override
    public List<Subscription> getAllSubscriptions() {
        return subscriptions;
    }
    @Override
    public BankCard createBankCard(User user, BankCardType type) {
        String generatedCardNumber = "4444-4444-4444-4444";

        if (type == BankCardType.CREDIT) {
            return new CreditBankCard(generatedCardNumber, user);
        } else {
            return new DebitBankCard(generatedCardNumber, user);
        }
    }

}
