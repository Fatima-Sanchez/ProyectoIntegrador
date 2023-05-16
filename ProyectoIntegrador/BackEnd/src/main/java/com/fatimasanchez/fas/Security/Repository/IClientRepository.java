/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fatimasanchez.fas.Security.Repository;

import com.fatimasanchez.fas.Security.Entity.Client;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Client, Integer>{
    Optional<Client> findByUsername(String username);
    
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
