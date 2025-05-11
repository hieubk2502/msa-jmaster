package com.dev.auth.repository;

import com.dev.auth.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Long> {

//    @Query(value = "SELECT * FROM ACCOUNT.ACCOUNT WHERE USER1_NAME = :username", nativeQuery = true)
    Account findByUserName(String username);
}
