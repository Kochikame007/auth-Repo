package com.demo.security.model.authorization;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "redirect_url")
public class RedirectUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "redirect_url")
    private String redirectUrl;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
