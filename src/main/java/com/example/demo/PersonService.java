package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entitymodel.Person;
import com.example.demo.repo.PersonRepo;

@Component
public class PersonService {
  
  @Lazy 
  @Autowired
  PersonService self;

  @Autowired
  PersonRepo personRepo;
  
  @Transactional(isolation=Isolation.READ_COMMITTED)
  public List<Person> getPersonsByFirstName(String fname) {
    return personRepo.findByFirstName(fname);
  }
  
  
  @Transactional(isolation = Isolation.SERIALIZABLE)
  public void modifyPersonFirstName() {
    
    String fname = "EElon";
    System.err.println("getting persons");
    self.getPersonsByFirstName(fname);
    System.err.println("done getting persons");

        
  }

}
