package com.example.login.controller;

import com.example.login.Payload.AccountPayload;
import com.example.login.model.Account;
import com.example.login.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LoginController {
    @Autowired
    AccountService accountService;
    @PostMapping("login1")
    public ResponseEntity<?> login(@RequestBody AccountPayload accountPayload){
        Optional<Account> accountOptional = accountService.findByUsername(accountPayload.getUsername());
        accountService.save(accountOptional.get());
        if(accountOptional.isPresent()){
            if(accountPayload.getPassword().equals(accountOptional.get().getPassword())){
                return ResponseEntity.ok().body("Login successfully");
            }else {
                return ResponseEntity.badRequest().body("Password fails");
            }
        }else {
            return ResponseEntity.badRequest().body("Username not found");
        }
    }
}
