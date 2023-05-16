/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatimasanchez.fas.Security.Service;

import com.fatimasanchez.fas.Security.Entity.Client;
import com.fatimasanchez.fas.Security.Repository.IClientRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClientService {
    @Autowired
    IClientRepository iclientRepository;
    
    public Optional<Client> getByUsername(String username){
        return iclientRepository.findByUsername(username);
    }
    
    public boolean existsByUsername(String username){
        return iclientRepository.existsByUsername(username);
    }
    
    public boolean existsByEmail(String email){
        return iclientRepository.existsByEmail(email);
    }
    
    public void save(Client client){
        iclientRepository.save(client);
    }
}
