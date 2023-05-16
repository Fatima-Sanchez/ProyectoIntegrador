package com.fatimasanchez.fas.Service;

import com.fatimasanchez.fas.Entity.User;
import org.springframework.stereotype.Service;
import com.fatimasanchez.fas.Interface.IUserService;
import com.fatimasanchez.fas.Repository.IUserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
    
@Service
public class ImpUserService implements IUserService {
    @Autowired IUserRepository iuserRepository;
    
    @Override
    public List<User> getUser() {
        List<User> users = iuserRepository.findAll();
        return users;
    }

    @Override
    public void saveUser(User user) {
        iuserRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        iuserRepository.deleteById(id);
    }

    @Override
    public User findUser(Long id) {
        User user = iuserRepository.findById(id).orElse(null);
        return user;
    }
    
}
