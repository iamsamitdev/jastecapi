package com.itgenius.jastecapi.repository;

import com.itgenius.jastecapi.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
//      Optional<User> findByUsername(String username);
//      public User findByUsername(String username);
//      Optional<User> findByUsernameAndPassword(String username, String password);
}
