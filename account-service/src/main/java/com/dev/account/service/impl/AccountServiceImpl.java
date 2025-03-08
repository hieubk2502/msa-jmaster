package com.dev.account.service.impl;

import com.dev.account.domain.Account;
import com.dev.account.dto.sdi.CreateAccountRequestSdi;
import com.dev.account.dto.sdi.UpdateAccountRequestSdi;
import com.dev.account.dto.sdo.AccountResponseSdo;
import com.dev.account.mapper.AccountMapper;
import com.dev.account.repository.AccountRepository;
import com.dev.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountMapper accountMapper;

    @Override
    public void add(CreateAccountRequestSdi accountDTO) {
        Account account = accountMapper.toAccount(accountDTO);

        accountRepository.save(account);
    }

    @Override
    public void update(UpdateAccountRequestSdi accountDTO) {
        Account account = accountRepository.getByUserName(accountDTO.getUserName());
        if (account != null) {
            accountRepository.save(account);
        }
    }

    @Override
    public void updatePassword(UpdateAccountRequestSdi accountDTO) {
        Account account = accountRepository.getByUserName(accountDTO.getUserName());
        if (account != null) {
            accountRepository.save(account);
        }
    }

    @Override
    public void delete(String  userName) {
        Account account = accountRepository.getByUserName(userName);
        if (account != null) {
            accountRepository.delete(account);
        }
    }

    @Override
    public List<AccountResponseSdo> getAll() {
        return accountRepository.findAll()
                .stream()
                .map(accountMapper::toAccountResponseSdo)
                .collect(Collectors.toUnmodifiableList());

    }

    @Override
    public AccountResponseSdo getOne(String id) {
        Account account = accountRepository.getByUserName(id);
        return account != null ?
                accountMapper.toAccountResponseSdo(account) : null;
    }
}