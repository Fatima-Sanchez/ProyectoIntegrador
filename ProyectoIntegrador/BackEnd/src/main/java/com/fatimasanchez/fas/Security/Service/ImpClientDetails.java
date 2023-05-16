/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatimasanchez.fas.Security.Service;

import com.fatimasanchez.fas.Security.Entity.Client;
import com.fatimasanchez.fas.Security.Entity.PrincipalClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class ImpClientDetails implements UserDetailsService{
    @Autowired
    ClientService clientService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientService.getByUsername(username).get();
        return PrincipalClient.build(client);
    }
}
