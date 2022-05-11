package com.example.login.service;

import com.example.login.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Account save(Account account);
    void deleteById(Long id);
    Optional<Account> findById(Long id);
    List<Account> findAll();

    Optional<Account> findByUsername(String username);
}
