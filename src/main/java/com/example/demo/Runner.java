package com.example.demo;

import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entitymodel.Person;
import com.example.demo.repo.PersonRepo;

@Component
public class Runner implements CommandLineRunner {

  @Autowired
  PersonRepo personRepo;
  
  @Lazy
  @Autowired
  Runner self;
  
  @Autowired
  PersonService personService;
  
  @Override
  public void run(String... args) throws Exception { 
    
    self.populatePersons();
    
    List<Person> persons = personService.getPersonsByFirstName("Elon");
    
    System.err.println(persons);
    
  }

  @Transactional(isolation=Isolation.DEFAULT)
  public void populatePersons(String... args) throws Exception {

    Scanner myObj = new Scanner(System.in);  
    System.err.println("hello");
    
    //Person p = personRepo.getById(new Long(11));
    
    Person p1 = new Person();
    p1.setFirstName("Dennis");
    p1.setLastName("Ritchie");
    p1.setCareer("co-author C Language");
    System.err.println(p1);
    personRepo.save(p1);
    
    Person p2 = new Person();
    p2.setFirstName("Roy");
    p2.setLastName("Fielding");
    p2.setCareer("Computer Scientist");
    System.err.println(p2);
    personRepo.save(p2);
    
    Person p3 = new Person();
    p3.setFirstName("Guido");
    p3.setLastName("Van Rossum,");
    p3.setCareer("Creator of Python");
    System.err.println(p3);
    personRepo.save(p3);
    
    Person p4 = new Person();
    p4.setFirstName("Elon");
    p4.setLastName("Musk");
    p4.setCareer("Auto and Space Entrepreneur");
    System.err.println(p4);
    personRepo.save(p4);
    
    System.err.println("trigger v2 elon.. just press enter");
    myObj.nextLine();  
    System.err.println("v2 ing elon..");  
    
    p4.setFirstName("EElon");
    p4.setLastName("Mussk");
    p4.setCareer("Auto and Space Entrepreneur + NeuralLink + OpenAI");
    System.err.println(p4);
    personRepo.save(p4);
    
    System.err.println("trigger flush..press enter");
    myObj.nextLine();  
    personRepo.flush();
    System.err.println("flushed.");  
    
    System.err.println("exit runner.. i.e commit transation.. ..press enter");    
    myObj.nextLine();  
    System.err.println("getting the trasaction commited.");  
    myObj.close();
    
  }

}
