package com.riad8321.flashcash.repository;

import com.riad8321.flashcash.model.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query(value="SELECT u FROM User LEFT JOIN FETCH u .links WHERE u.email=:email ")
    public Optional<User> findUserByEmail(String email);
}
