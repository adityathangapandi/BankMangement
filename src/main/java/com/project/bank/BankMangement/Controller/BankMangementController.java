package com.project.bank.BankMangement.Controller;

import com.project.bank.BankMangement.Entity.BankMangement;
import com.project.bank.BankMangement.Service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequestMapping("/api/bankmanagement")

@RestController
public class BankMangementController {
    @Autowired
    private BankService service;
    @GetMapping("/")
    public String getBank(){
        return "Hello everyone";
    }

//    @PostMapping("/add-details")
//    public HashMap<String, Object> addBankDetails(@RequestBody BankMangement b){
//        HashMap<String,Object> response=new HashMap<String,Object>();
//        try{
//            BankMangement  addDetails=service.addBankDetails(b);
//            response.put("message","The bank is added sucessfully");
//            response.put("message",addDetails);
//            return response;
//
//        }
//        catch(Exception e){
//            response.put("message","unable to add the details ");
//            return response;
//        }
//    }


}
