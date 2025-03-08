package com.dev.account.dto.sdo;

import lombok.Data;

import java.util.Set;

@Data
public class AccountResponseSdo {

    Long id;

    String fullName;

    String userName;

    String password;

    Set<String> roles;

}
