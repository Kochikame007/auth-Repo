package com.demo.security.model.authorization;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "client_tbl")
public class Client {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="client_id")
    private String clientId;

    private String secret;

    @OneToMany(mappedBy="client")
    private List<Scopes> scope;

    @OneToMany(mappedBy="client")
    private List<AuthorizationGrantType> authGrant;

    @OneToMany(mappedBy="client")
    private List<RedirectUrl> redirectUrl;

    @OneToMany(mappedBy="client")
    private List<AuthenticationMethod> authenticationMethods;


}
