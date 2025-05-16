package com.project.bank.BankMangement.Service;


import com.project.bank.BankMangement.Repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService{
    @Autowired
    private BankRepository repo;
}
