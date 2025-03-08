package com.dev.account.repository;

import com.dev.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account, Long> {

    Account getByUserName(String userName);

}
