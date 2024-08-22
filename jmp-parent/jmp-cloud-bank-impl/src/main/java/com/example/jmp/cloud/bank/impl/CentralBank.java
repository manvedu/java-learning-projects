package com.example.jmp.cloud.bank.impl;

import com.example.jmp.dto.BankCard;
import com.example.jmp.dto.BankCardType;
import com.example.jmp.dto.User;
import com.example.jmp.bank.api.Bank;

public class CentralBank implements Bank {

    @Override
    public BankCard createBankCard(User user, BankCardType type) {
        return new BankCard("CentralBankCardNumber", user);
    }
}