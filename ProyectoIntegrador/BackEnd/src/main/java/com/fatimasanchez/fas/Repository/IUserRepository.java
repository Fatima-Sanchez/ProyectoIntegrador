package com.fatimasanchez.fas.Repository;

import com.fatimasanchez.fas.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long>{
    
}
