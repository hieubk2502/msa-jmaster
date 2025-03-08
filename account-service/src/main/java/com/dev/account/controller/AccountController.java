package com.dev.account.controller;

import com.dev.account.dto.sdi.CreateAccountRequestSdi;
import com.dev.account.dto.sdi.UpdateAccountRequestSdi;
import com.dev.account.dto.sdo.AccountResponseSdo;
import com.dev.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // add new
    @PostMapping
    public void addAccount(@RequestBody CreateAccountRequestSdi accountDTO) {
        accountService.add(accountDTO);
    }

    // get all
    @GetMapping
    public List<AccountResponseSdo> getAll() {
        return accountService.getAll();
    }

    @GetMapping("/{username}")
    public ResponseEntity<AccountResponseSdo> get(@PathVariable(name = "username") String username) {

        return new ResponseEntity<>(accountService.getOne(username), HttpStatus.OK);
    }

    @DeleteMapping("/{userName}")
    public void delete(@PathVariable(name = "userName") String userName) {
        accountService.delete(userName);
    }

    @PutMapping
    public void update(@RequestBody UpdateAccountRequestSdi accountDTO) {
        accountService.update(accountDTO);
    }
}

