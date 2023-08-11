package com.riad8321.flashcash.repository;

import com.riad8321.flashcash.model.Link;
import com.riad8321.flashcash.model.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactListRepository extends CrudRepository<Link, Integer> {
    @Query(value = "SELECT c FROM Link c WHERE c.user1.email = :email")
    List<Link> findLinksByUser1Email(String email);

}