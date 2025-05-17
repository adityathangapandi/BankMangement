package com.project.bank.BankMangement.Service;


import com.project.bank.BankMangement.Entity.BankMangement;
import com.project.bank.BankMangement.Repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public  class BankServiceImpl implements BankService {
    @Autowired
    private BankRepository repo;

    public BankMangement addBankDetails(BankMangement b) {
        BankMangement presentAccount = repo.findByAccountNumber(b.getAccountNumber());
        if (presentAccount != null)
            throw new RuntimeException("Account already exist ");
        else
            return repo.save(b);
    }

    @Override
    public List<BankMangement> getBankAllDetails() {
        List<BankMangement> presentAccount = repo.findAll();
        if (presentAccount.isEmpty())
            throw new RuntimeException("No Accounts active ");
        else
            return presentAccount;
    }

    @Override
    public Boolean deleteBankDetails(Long id) {
        Optional<BankMangement> deleteBankDetails = repo.findById(id);
        if (deleteBankDetails.isEmpty()) {
            throw new RuntimeException("Bank details are not available");
        } else {
            repo.deleteById(id);
            return true;
        }
    }

    @Override
    public BankMangement updateStudentDetails(Long id, BankMangement b) {

        Optional<BankMangement> presentBankDetails = repo.findById(id);
        if (presentBankDetails.isEmpty()) {
            throw new RuntimeException("No Student present with the Id to update");
        } else {
            BankMangement needToUpdate = presentBankDetails.get();
            needToUpdate.setAccountHolderName(b.getAccountHolderName());
            needToUpdate.setAccountNumber(b.getAccountNumber());
            needToUpdate.setPhoneNumber(b.getPhoneNumber());
            needToUpdate.setEmailId(b.getEmailId());
            return repo.save(needToUpdate);
        }

    }

    @Override
    public List<BankMangement> getUsernameDetails(String accountHolderName) {
        List<BankMangement> useraccount = repo.findByAccountHolderName(accountHolderName);
        if (useraccount.isEmpty()) {
            throw new RuntimeException("Account not  exist ");
        }
        else {
            return useraccount;
        }

    }



}







