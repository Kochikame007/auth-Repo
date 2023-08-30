package com.demo.security.respository;

import com.demo.security.model.authorization.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    @Query("""
            SELECT c from Client c where c.clientId =:clientId
            """)
    Optional<Client> findByClientId(String clientId);


}