package com.dev.account.dto.sdi;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UpdateAccountRequestSdi {

    String fullName;

    String password;

    String userName;

    Set<String> roles;
}
