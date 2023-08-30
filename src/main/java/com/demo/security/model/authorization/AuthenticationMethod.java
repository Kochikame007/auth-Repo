package com.demo.security.model.authorization;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "auth_meth_tbl")
public class AuthenticationMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="auth_meth")
    private String authenticationMethod;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

}
