package com.lustre.mall.oauth2.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

@Service
public class UserDetailsManagerService implements UserDetailsManager {

    private UserDetailsManager userDetailsManager;

    public UserDetailsManagerService(UserDetailsManager userDetailsManager) {
        this.userDetailsManager = userDetailsManager;
    }

    @Override
    public void createUser(UserDetails userDetails) {
        userDetailsManager.createUser(userDetails);
    }

    @Override
    public void updateUser(UserDetails userDetails) {
        userDetailsManager.updateUser(userDetails);
    }

    @Override
    public void deleteUser(String s) {
        userDetailsManager.deleteUser(s);
    }

    @Override
    public void changePassword(String s, String s1) {
        userDetailsManager.changePassword(s, s1);
    }

    @Override
    public boolean userExists(String s) {
        return userDetailsManager.userExists(s);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDetailsManager.loadUserByUsername(s);
    }
}
