package com.fatimasanchez.fas.Interface;

import com.fatimasanchez.fas.Entity.User;
import java.util.List;


public interface IUserService {

    public List<User> getUser();
    
    public void saveUser(User user);
    
    public void deleteUser(Long id);
    
    public User findUser(Long id);
}
