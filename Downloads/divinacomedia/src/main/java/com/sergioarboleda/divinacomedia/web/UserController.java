/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sergioarboleda.divinacomedia.web;

import com.sergioarboleda.divinacomedia.model.User;
import com.sergioarboleda.divinacomedia.services.UserServices;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hldua
 */
@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")
public class UserController {
    
    @Autowired
    private UserServices service;
    
    @GetMapping("/all")
    public List<User> getUsers(){
        return service.getAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return service.save(user);
    }
    
    @GetMapping("/{email}")
    public boolean existEmail(@PathVariable("email")String email){
        return service.getUserByEmail(email);
    }
    
    @GetMapping("/{email}/{password}")
    public User authUser(@PathVariable("email")String email,@PathVariable("password")String password){
        return service.getUserByEmailAndPassword(email,password);
    }
}
