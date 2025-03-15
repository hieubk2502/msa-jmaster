package com.dev.account.dto.sdi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
public class CreateAccountRequestSdi {

    String fullName;

    String userName;

    String password;

    Set<String> roles;

    public static void main(String[] args) throws JsonProcessingException {
        CreateAccountRequestSdi createAccountRequestSdi = new CreateAccountRequestSdi();
        Set<String> stringSet = new HashSet<>();
        stringSet.add("USER");
        stringSet.add("ADMIN");

        createAccountRequestSdi.setRoles(stringSet);
        System.out.println(new ObjectMapper().writeValueAsString(createAccountRequestSdi));
    }
}
