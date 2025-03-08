package com.dev.account.domain;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Table(name = "account")
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "full_name")
    String fullName;

    @Column(name = "user_name", unique = true)
    String userName;

    @Column(name = "password")
    String password;

    @ElementCollection
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "account_id"))
    @Column(name = "role")
    private Set<String> roles;

}
