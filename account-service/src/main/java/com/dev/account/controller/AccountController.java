package com.dev.account.controller;

import com.dev.account.dto.CreateStatisticDTO;
import com.dev.account.dto.MessageDTO;
import com.dev.account.dto.sdi.CreateAccountRequestSdi;
import com.dev.account.dto.sdi.UpdateAccountRequestSdi;
import com.dev.account.dto.sdo.AccountResponseSdo;
import com.dev.account.service.AccountService;
import com.dev.account.service.client.NotificationService;
import com.dev.account.service.client.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private StatisticService statisticService;

    @Autowired
    private NotificationService notificationService;

    // add new
    @PostMapping("/create")
    public void addAccount(@RequestBody CreateAccountRequestSdi accountDTO) {
        accountService.add(accountDTO);

        statisticService.add(
                CreateStatisticDTO
                        .builder().message("Test!")
                        .createdDate(new Date())
                        .build());

        // send mail
        notificationService.sendNotification(
                MessageDTO
                        .builder()
                        .from("hieu@gmail.com")
                        .to(accountDTO.getUserName())
                        .toName(accountDTO.getFullName())
                        .content("")
                        .subject("")
                        .build());

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

