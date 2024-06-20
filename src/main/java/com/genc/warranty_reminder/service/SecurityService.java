package com.genc.warranty_reminder.service;

import com.genc.warranty_reminder.model.UserAuthenticationData;
import com.genc.warranty_reminder.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityService  implements UserDetailsService {
    @Autowired
    AuthenticationRepository authenticationRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String email=null;
        String password=null;
        List<UserAuthenticationData>users= authenticationRepository.findByEmail(username);
       List<GrantedAuthority>authorities=new ArrayList<>();
       if(users.size()==0)
       {
           throw new UsernameNotFoundException("user list not found");

       }
       else {
           authorities.add(new SimpleGrantedAuthority(users.get(0).getRole()));
           email=users.get(0).getEmail();
           password=users.get(0).getPassword();
       }

        return new User(email,password,authorities);
    }
}
