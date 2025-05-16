package com.project.bank.BankMangement.Controller;

import com.project.bank.BankMangement.Entity.BankMangement;
import com.project.bank.BankMangement.Service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RequestMapping("/api/bankmanagement")

@RestController
public class BankMangementController {
    @Autowired
    private BankService service;


    @PostMapping("/add-details")
    public HashMap<String, Object> addBankAccount(@RequestBody BankMangement b){
        HashMap<String,Object> response=new HashMap<String,Object>();
        try{
            BankMangement  addDetails=service.addBankDetails(b);
            response.put("message","The bank is added sucessfully");
            response.put("message",addDetails);
            return response;

        }
        catch(Exception e){
            response.put("message",e.getMessage());

            return response;
        }
    }
    @GetMapping("/get-details")
    public HashMap<String, Object> getBankAccount(){
        HashMap<String, Object> response=new HashMap<String,Object>();
        try{
            List<BankMangement> presentDetails = service.getBankAllDetails();
            response.put("message","Sucessfully fetched the details ");
            response.put("message",presentDetails);
            return response;

        }
        catch(Exception e){
            response.put("message","somenthing went wrong");
            return response;
        }
    }



}
