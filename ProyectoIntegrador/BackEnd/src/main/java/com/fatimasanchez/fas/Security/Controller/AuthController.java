/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatimasanchez.fas.Security.Controller;

import com.fatimasanchez.fas.Security.Entity.Client;
import com.fatimasanchez.fas.Security.Entity.Rol;
import com.fatimasanchez.fas.Security.Enums.RolName;
import com.fatimasanchez.fas.Security.Service.ClientService;
import com.fatimasanchez.fas.Security.Service.RolService;
import com.fatimasanchez.fas.Security.jwt.JwtProvider;
import jakarta.validation.Valid;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    ClientService clientService;
    @Autowired
    RolService rolService;
    @Autowired
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NewClient newClient, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Error en los campos o mail invalido", HttpStatus.BAD_REQUEST));
        
        if(clientService.existByUsername(username.getUsername()))
            return new ResponseEntity(new Mensaje("Nombre de usuario existente"), HttpStatus.BAD_REQUEST);
        
        if(clientService.existByEmail(username.getEmail()))
            return new ResponseEntity(new Mensaje("El email ya existe"), HttpStatus.BAD_REQUEST);
        
        Client client = new Client(newClient.getName(), newClient.getUsername(), newClient.getEmail(), 
                passwordEncoder.encode(newClient.getPassword()));
        
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolName(RolName.ROLE_USER).get());
        
        if(newClient.getRoles().contains("adminm"))
            roles.add(rolService.getByRolName(RolName.ROLE_ADMIN).get());
        client.setRoles(roles);
        clientService.save(client);
        
        return new ResponseEntity(new Mensaje("Usuario guardado"), HttpStatus.CREATED);
        
    }
    
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginClient loginClient, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Error en los campos"), HttpStatus.BAD_REQUEST);
        
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginClient.getUsername(), loginclient.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = JwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (userDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto, HttpStatus.OK)
    }
}
