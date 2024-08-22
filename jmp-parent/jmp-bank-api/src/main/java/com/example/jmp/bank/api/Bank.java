package com.example.jmp.bank.api;

import com.example.jmp.dto.BankCard;
import com.example.jmp.dto.User;
import com.example.jmp.dto.BankCardType;


public interface Bank {
     BankCard createBankCard(User user, BankCardType type);
}

