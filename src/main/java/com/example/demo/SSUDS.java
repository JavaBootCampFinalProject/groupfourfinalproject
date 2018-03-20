package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Service
public class SSUDS implements UserDetailsService {
    @Autowired
    private AppUserRepository userRepository;

    public SSUDS(AppUserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            AppUser myUser = userRepository.findAppUserByUsername(username);
            if(myUser == null){
                return null;
            }
            return new User(myUser.getUsername(), myUser.getPassword(), getAuthorities(myUser));
        } catch (Exception e){
            throw new UsernameNotFoundException("User not found");
        }
    }

    private Set<GrantedAuthority> getAuthorities(AppUser appuser) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (AppRole role : appuser.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleName());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }
    }
