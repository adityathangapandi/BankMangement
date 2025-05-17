package com.project.bank.BankMangement.Service;

import com.project.bank.BankMangement.Entity.BankMangement;

import java.util.List;

public interface BankService {
    public  BankMangement addBankDetails(BankMangement b);

    public List<BankMangement> getBankAllDetails();

    Boolean deleteBankDetails(Long id);

    BankMangement updateStudentDetails(Long id, BankMangement b);
}
