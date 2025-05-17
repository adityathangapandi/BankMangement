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
    private final String emailId="aditya@gmail.com";
    private final String password="aditya@4311";


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
            response.put("Account details",presentDetails);
            return response;
        }
        catch(Exception e){
            response.put("message",e.getMessage());
            return response;
        }
    }
    @DeleteMapping("/delete-mapping")
    public HashMap<String, Object> deleteBankAccount(@RequestParam long id){
        HashMap<String, Object> response =new HashMap<String,Object>();
        try{
            Boolean deleteBankDetails=service.deleteBankDetails(id);
            response.put("message","student details deleted");
            response.put("Student",deleteBankDetails);
            return response;
        }
        catch(Exception e){
            response.put("error",e.getMessage());
            return response;
        }
    }
    @PutMapping("/update-Bankdetails")
    public HashMap<String,Object> updateStudent(@RequestParam Long id,@RequestBody BankMangement b){
        HashMap<String,Object> response=new HashMap<String,Object>();
        try{
            BankMangement updateBankDetails=service.updateStudentDetails(id,b);
            response.put("message","student data updated sucessfully");
            response.put("updated student",updateBankDetails);
            return response;
        }
        catch(Exception e){

            response.put("error",e.getMessage());
            return response;
        }

    }
    @GetMapping("/get-customerdetails")
     public HashMap<String, Object> getUsernameDetails(@RequestParam String accountHolderName){
        HashMap<String,Object> response=new HashMap<String,Object>();
        try{
            List<BankMangement> presentDetails = service.getUsernameDetails(accountHolderName);
            response.put("message","Successfully fetched the details ");
            response.put("Account details",presentDetails);
            return response;
        }
        catch(Exception e){
            response.put("message",e.getMessage());
            return response;
        }
    }
    @PostMapping("/login")
    public HashMap<String,Object> loginUser(@RequestParam String email,@RequestParam String pwd) {
        HashMap<String, Object> response = new HashMap<String, Object>();
        try{
            if(email.equals(emailId) && pwd.equals(password)) {
                response.put("message", "Aditya logged in successfully");
                return response;
            }
            else{
                response.put("msg","Invalid details please try again");
                return response;
            }
        } catch (Exception e) {
          response.put("message","some error is occured");
          return response;
        }

    }



}
