package com.example.login.controller;

import com.example.login.Payload.AccountPayload;
import com.example.login.model.Account;
import com.example.login.repository.AccountRepository;
import com.example.login.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/home")
public class AccountController {
    @Autowired
    AccountService accountService;
    @GetMapping("findAll")
    public ResponseEntity<List<Account>> findAll(){
        return ResponseEntity.ok().body(accountService.findAll());
    }

    @PostMapping("create")
    public ResponseEntity<Account> create(@RequestBody Account account){
        return ResponseEntity.ok().body(accountService.save(account));
    }


}
