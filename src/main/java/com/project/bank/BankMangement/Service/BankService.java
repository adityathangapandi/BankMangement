package com.project.bank.BankMangement.Service;

import com.project.bank.BankMangement.Entity.BankMangement;

import java.util.List;

public interface BankService {
    public  BankMangement addBankDetails(BankMangement b);

    List<BankMangement> getBankAllDetails();
}
