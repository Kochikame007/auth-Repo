package com.demo.security.model.authorization;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "auth_grant_type_tbl")
public class AuthorizationGrantType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "auth_grant_type")
    private String authGrantType;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
