package com.itgenius.jastecapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itgenius.jastecapi.exception.ResourceNotFoundException;
import com.itgenius.jastecapi.model.User;
import com.itgenius.jastecapi.repository.UserRepository;
import com.itgenius.jastecapi.service.RegistrationLoginService;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    private RegistrationLoginService service;
    
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") int userId)
        throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + userId));
        return ResponseEntity.ok().body(user);
    }
    
    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") int userId,
         @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + userId));

        user.setFirstname(userDetails.getFirstname());
        user.setLastname(userDetails.getLastname());
        user.setImgprofile(userDetails.getImgprofile());
        user.setStatus(userDetails.getStatus());
        
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
        
    }

    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") int userId)
         throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + userId));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
    // Registration new user
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) throws Exception{
        
        String tempUsername = user.getUsername();
        
        if(tempUsername != null && !"".equals(tempUsername)){
            userRepository.save(user);
            return "{\"code\":\"200\",\"status\":\"success\", \"message\":\"Register Success\"}";
        }else{
            return "{\"code\":\"400\",\"status\":\"fail\", \"message\":\"Register Fail\"}";
        }
        
    }
    
    // Login
    @PostMapping("/login")
    public Optional<User> loginUser(@RequestBody User user)  throws Exception{
        String tempUsername = user.getUsername();
        String tempPass = user.getPassword();
//        System.out.println(tempUsername);
//        System.out.println(tempPass);
        Optional<User> userObj = null;
        if(tempUsername != null && tempPass != null){
//              userObj = service.findByUsernameAndPassword(tempUsername, tempPass);
        }
        
        if(userObj == null){
             throw new Exception("Bad credentials");
        }
//        System.out.println(userObj);
        return userObj;
    }
    
    
}
