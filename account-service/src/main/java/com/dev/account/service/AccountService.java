package com.dev.account.service;

import java.util.List;

import com.dev.account.dto.sdi.CreateAccountRequestSdi;
import com.dev.account.dto.sdi.UpdateAccountRequestSdi;
import com.dev.account.dto.sdo.AccountResponseSdo;

public interface AccountService {
    void add(CreateAccountRequestSdi accountDTO);

    void update(UpdateAccountRequestSdi accountDTO);

    void updatePassword(UpdateAccountRequestSdi accountDTO);

    void delete(String userName);

    List<AccountResponseSdo> getAll();

    AccountResponseSdo getOne(String id);
}

