//package com.demo.security.service;
//
////import com.demo.security.model.Users;
//import com.demo.security.respository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Service
//public class CustomUserService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepo;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
////        Users user = userRepo.findByEmail(email);
//
////        if (user == null) {
////            throw new UsernameNotFoundException("Username doesnot exist in the database");
////
////        } else {
////            return new User(
////                    "demo@mail.com",
////                    "password",
////                    true,
////                    true,
////                    true,
////                    true,
////                    getAuthorities(List.of(user.getRole())));
////        }
//    }
//
//    private Collection<? extends GrantedAuthority> getAuthorities(List<String> roles) {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for (String role : roles) {
//            authorities.add(new SimpleGrantedAuthority(role));
//        }
//        return authorities;
//    }
//
//}
