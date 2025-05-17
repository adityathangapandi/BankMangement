package com.project.bank.BankMangement.Repository;

import com.project.bank.BankMangement.Entity.BankMangement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public  interface BankRepository extends JpaRepository<BankMangement,Long> {
    BankMangement findByAccountNumber(long accountNumber);

    List<BankMangement> findByAccountHolderName(String accountHolderName);
}
