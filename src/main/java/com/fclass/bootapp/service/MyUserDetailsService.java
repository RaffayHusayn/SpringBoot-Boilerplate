package com.fclass.bootapp.service;

import com.fclass.bootapp.model.User;
import com.fclass.bootapp.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("404 : user not found");
        }
        return new UserPrincipal(user);
    }
}
