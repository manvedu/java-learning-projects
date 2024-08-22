module com.example.jmp.application {
    uses com.example.jmp.bank.api.Bank;
    uses com.example.jmp.service.api.Service;

    requires com.example.jmp.cloud.bank.impl;
    requires com.example.jmp.cloud.service.implementation;
    requires com.example.jmp.dto;
}
