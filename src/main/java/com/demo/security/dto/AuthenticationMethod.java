//package com.demo.security.model;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//
//@Entity
//@Table(name = "authentication_method_tb")
//
//@Getter
//@Setter
//public class AuthenticationMethod {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column(name = "authentication_method")
//    private String authenticationMethod;
//
//    @ManyToOne
//    private Client client;
//
//
//    public static AuthenticationMethod from(ClientAuthenticationMethod authenticationMethod , Client client) {
//        AuthenticationMethod a = new AuthenticationMethod();
//            a.setAuthenticationMethod(authenticationMethod.getValue());
//            a.setClient(client);
//        return a;
//    }
//}
