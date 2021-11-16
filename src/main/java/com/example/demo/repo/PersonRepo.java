package com.example.demo.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entitymodel.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long>,
    PagingAndSortingRepository<Person, Long>, JpaSpecificationExecutor<Person> {

  @Transactional(isolation=Isolation.REPEATABLE_READ)
  public List<Person> findByFirstName(String name);


}
