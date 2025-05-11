package com.example.client_register_service.repository;

import com.example.client_register_service.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByClientId(String clientId);

    void deleteByClientId(String clientId);
}
