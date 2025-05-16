package com.project.bank.BankMangement.Service;


import com.project.bank.BankMangement.Entity.BankMangement;
import com.project.bank.BankMangement.Repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class BankServiceImpl implements BankService{
    @Autowired
    private BankRepository repo;
   public BankMangement addBankDetails(BankMangement b){
        BankMangement presentAccount=repo.findByAccountNumber(b.getAccountNumber());
        if(presentAccount!=null)
            throw new RuntimeException("Account already exist ");
        else
            return repo.save(b);
    }

    @Override
    public List<BankMangement> getBankAllDetails() {
        return List.of();
    }

}
