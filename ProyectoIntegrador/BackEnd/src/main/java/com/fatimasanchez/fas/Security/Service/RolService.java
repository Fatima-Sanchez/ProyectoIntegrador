/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatimasanchez.fas.Security.Service;

import com.fatimasanchez.fas.Security.Entity.Rol;
import com.fatimasanchez.fas.Security.Enums.RolName;
import com.fatimasanchez.fas.Security.Repository.IRolRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional 
public class RolService {
    @Autowired
    IRolRepository irolRepository;
    
    public Optional<Rol> getByRolName(RolName rolName){
        return irolRepository.findByRolName(rolName);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);  
    }
    
}
