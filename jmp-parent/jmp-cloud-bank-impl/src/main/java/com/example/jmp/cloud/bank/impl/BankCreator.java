package com.example.jmp.cloud.bank.impl;

import com.example.jmp.bank.api.Bank;

public class BankCreator {

    public static Bank createBank(BankType bankType) {
        switch (bankType) {
            case RETAIL_BANK:
                return new RetailBank();
            case INVESTMENT_BANK:
                return new InvestmentBank();
            case CENTRAL_BANK:
                return new CentralBank();
            default:
                throw new IllegalArgumentException("Unknown bank type: " + bankType);
        }
    }
}