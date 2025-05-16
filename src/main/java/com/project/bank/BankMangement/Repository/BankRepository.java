package com.project.bank.BankMangement.Repository;

import com.project.bank.BankMangement.Entity.BankMangement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface BankRepository extends JpaRepository<BankMangement,Long> {
}
