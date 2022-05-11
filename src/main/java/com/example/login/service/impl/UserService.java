package com.example.login.service.impl;

import com.example.login.model.Account;
import com.example.login.model.CustomAccountDetails;
import com.example.login.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class UserService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> account = accountRepository.findByUsername(username);
        if(account.isPresent()){
            return new CustomAccountDetails(account.get());
        }

        throw new UsernameNotFoundException(username);
    }
}
