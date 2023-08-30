package com.demo.security.service;


import com.demo.security.mapper.CustomMapper;
import com.demo.security.mapper.Mapper;
import com.demo.security.model.authorization.Client;
import com.demo.security.respository.ClientRepository;
import jdk.jfr.Registered;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService implements RegisteredClientRepository {

    private final ClientRepository clientRepository;


    @Override
    public void save(RegisteredClient registeredClient) {
        Client client = new Client();
        client.setClientId(registeredClient.getClientId());
        client.setSecret(registeredClient.getClientSecret());
        client.setAuthenticationMethods(registeredClient.getClientAuthenticationMethods()
                .stream()
                .map(a -> CustomMapper.fromRegisteredClientToAuthMeth(a, client))
                .collect(Collectors.toList()));

        client.setAuthGrant(registeredClient.getAuthorizationGrantTypes()
                .stream()
                .map(a -> CustomMapper.fromRegisteredClientToAuthGrantType(a, client))
                .collect(Collectors.toList()));

        client.setRedirectUrl(registeredClient.getRedirectUris()
                .stream()
                .map(a -> CustomMapper.fromRegisteredClientToRedirectUri(a, client))
                .collect(Collectors.toList()));

        client.setScope(registeredClient.getScopes()
                .stream()
                .map(a -> CustomMapper.fromRegisteredClientToScope(a, client))
                .collect(Collectors.toList()));


        clientRepository.save(client);
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        var c = clientRepository.findByClientId(clientId);

        return c.map(CustomMapper::fromClient)
                .orElseThrow(() -> new RuntimeException("Client doest not exist"));
    }

    @Override
    public RegisteredClient findById(String id) {
        var client = clientRepository.findById(Long.parseLong(id));
        return client.map(CustomMapper::fromClient)
                .orElseThrow(() -> new RuntimeException("Client doest not exist"));
    }
}
