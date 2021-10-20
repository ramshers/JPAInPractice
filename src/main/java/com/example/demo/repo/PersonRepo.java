package com.example.demo.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entitymodel.Person;

@Repository
public interface PersonRepo extends 
    JpaRepository<Person, Long>, 
    PagingAndSortingRepository<Person, Long>, 
    JpaSpecificationExecutor<Person> {
  

    public Optional<Person> findByFirstName(String name);
    
  
}
