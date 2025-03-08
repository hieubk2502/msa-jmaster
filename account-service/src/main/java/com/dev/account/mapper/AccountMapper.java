package com.dev.account.mapper;

import com.dev.account.domain.Account;
import com.dev.account.dto.sdi.CreateAccountRequestSdi;
import com.dev.account.dto.sdo.AccountResponseSdo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account toAccount(CreateAccountRequestSdi createAccountRequestSdi);

    AccountResponseSdo toAccountResponseSdo(Account account);

}
