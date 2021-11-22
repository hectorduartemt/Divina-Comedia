/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sergioarboleda.divinacomedia.services;

import com.sergioarboleda.divinacomedia.model.User;
import com.sergioarboleda.divinacomedia.respositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.stereotype.Service;

/**
 *
 * @author hldua
 */
@Service
public class UserServices {
    
    @Autowired
    private UserRepository repository;
    
    public List<User> getAll(){
        return repository.getAll();
    }
    
    public User save(User user){
        if (user.getId()==null){
            List<User> existUsers = repository.getUserByNameOrEmail(user.getName(),user.getEmail());
            if(existUsers.isEmpty()){
                return repository.save(user);
            }else{
                return user;
            }
        }else{
            Optional<User> existUser =repository.getUserById(user.getId());
            if (existUser.isEmpty()){
                return repository.save(user);
            }else{
                return user;
            }
        }
    }
    
    public boolean getUserByEmail(String email){
        return repository.getUserByEmail(email).isPresent();
    }
    
    public User getUserByEmailAndPassword(String email, String password){
        Optional<User> user = repository.getUserByEmailAndPassword(email, password);
        if (user.isPresent()){
            return user.get();
        }else{
            return new User(null,email,password,"NO DEFINIDO");
        }
    }
}
