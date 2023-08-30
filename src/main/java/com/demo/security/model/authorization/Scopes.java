package com.demo.security.model.authorization;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
@Table(name = "scopes_tbl")
public class Scopes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String scope;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
