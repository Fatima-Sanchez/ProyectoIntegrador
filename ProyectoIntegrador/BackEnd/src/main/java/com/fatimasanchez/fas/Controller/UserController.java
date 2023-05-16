package com.fatimasanchez.fas.Controller;

import com.fatimasanchez.fas.Entity.User;
import com.fatimasanchez.fas.Interface.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired IUserService iuserService;
    
    @GetMapping("/user/traer")
    public List<User> getUser(){
        return iuserService.getUser();
    }
    
    @PostMapping("/user/crear")
    public String createUser(@RequestBody User user){
        iuserService.saveUser(user);
        return "Usuario creado correctamente";
    }
    
    @DeleteMapping("/user/borrar/{id}")
    public String deleteUser(@PathVariable Long id){
        iuserService.deleteUser(id);
        return "Usuario {id} eliminado correctamente";
    }
    
    @PutMapping("/user/editar/{id}")
    public User editUser(@PathVariable Long id,
                        @RequestParam("name") String newName,
                        @RequestParam("surname") String newSurname,
                        @RequestParam("img") String newImg){
        User user = iuserService.findUser(id);
        
        user.setName(newName);
        user.setSurname(newSurname);
        user.setImg(newImg);
        
        iuserService.saveUser(user);
        return user;
    }
    
    @GetMapping("/user/traer/perfil")
    public User findUser(){
        return iuserService.findUser((long)1);
    }
}
