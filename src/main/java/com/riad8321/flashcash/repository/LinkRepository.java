package com.riad8321.flashcash.repository;


import com.riad8321.flashcash.model.Link;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LinkRepository extends CrudRepository<Link, Long> {

}
