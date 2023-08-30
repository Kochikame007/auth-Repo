package com.demo.security.mapper;

import com.demo.security.model.authorization.*;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class CustomMapper {

    public static AuthenticationMethod fromRegisteredClientToAuthMeth(ClientAuthenticationMethod cam, Client c) {
        AuthenticationMethod am = new AuthenticationMethod();
        am.setAuthenticationMethod(cam.getValue());
        am.setClient(c);
        return am;
    }

    public static AuthorizationGrantType fromRegisteredClientToAuthGrantType(
            org.springframework.security.oauth2.core.AuthorizationGrantType auth, Client c) {
        AuthorizationGrantType agt = new AuthorizationGrantType();
        agt.setAuthGrantType(agt.getAuthGrantType());
        agt.setClient(c);
        return agt;
    }


    public static RedirectUrl fromRegisteredClientToRedirectUri(
            String uri, Client c) {
        RedirectUrl r = new RedirectUrl();
        r.setRedirectUrl(uri);
        r.setClient(c);
        return r;
    }


    public static Scopes fromRegisteredClientToScope(
            String scope, Client c) {
        Scopes s = new Scopes();
        s.setScope(scope);
        s.setClient(c);

        return s;
    }


    public static RegisteredClient fromClient(Client c) {
        return RegisteredClient.withId(String.valueOf(c.getId()))
                .clientId(c.getClientId())
                .clientSecret(c.getSecret())
                .authorizationGrantTypes(getAuthGrantTypes(c.getAuthGrant()))
                .redirectUris(getRedirectUri(c.getRedirectUrl()))
                .scopes(getScopes(c.getScope()))
                .clientAuthenticationMethods(getAuthMethods(c.getAuthenticationMethods()))
                .build();
    }

    private static Consumer<Set<org.springframework.security.oauth2.core.AuthorizationGrantType>> getAuthGrantTypes(List<AuthorizationGrantType> agt) {
        return s -> {
            for (AuthorizationGrantType a : agt) {
                s.add(new org.springframework.security.oauth2.core.AuthorizationGrantType(a.getAuthGrantType()));
            }
        };
    }


    private static Consumer<Set<String>> getRedirectUri(List<RedirectUrl> uri) {
        return s -> {
            for (RedirectUrl a : uri) {
                s.add(a.getRedirectUrl());
            }
        };
    }

    private static Consumer<Set<String>> getScopes(List<Scopes> scopes) {
        return s -> {
            for (Scopes a : scopes) {
                s.add(a.getScope());
            }
        };
    }

    private static Consumer<Set<ClientAuthenticationMethod>> getAuthMethods(List<AuthenticationMethod> am) {
        return s -> {
            for (AuthenticationMethod a : am) {
                s.add(new ClientAuthenticationMethod(a.getAuthenticationMethod()));
            }
        };
    }


}
