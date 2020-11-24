package com.itgenius.jastecapi.service;
import com.itgenius.jastecapi.model.User;
import com.itgenius.jastecapi.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationLoginService{
    @Autowired
    private UserRepository repo;
    
    
}
