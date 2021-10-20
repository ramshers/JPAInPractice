package com.example.demo;

import java.util.Scanner;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.demo.entitymodel.Person;
import com.example.demo.repo.PersonRepo;

@Component
public class Runner implements CommandLineRunner {

  @Autowired
  PersonRepo personRepo;
  
  @Override
  @Transactional
  public void run(String... args) throws Exception {

    System.out.println("hello");
    
    //Person p = personRepo.getById(new Long(11));
    
    //System.err.println(p);
    
    Person p1 = new Person();
    p1.setFirstName("Jeff");
    p1.setLastName("Bezos");
    p1.setCareer("Tech Entrepreneur");
    System.err.println(p1);
    personRepo.save(p1);
    
    System.err.println("before flush");
    personRepo.flush();
    System.err.println("after flush");

    Person p2 = new Person();
    p2.setFirstName("AMZN Jeff");
    p2.setLastName("Bezos");
    p2.setCareer("Tech and eCom Entrepreneur");
    System.err.println(p2);
    personRepo.save(p2);
    
    Scanner myObj = new Scanner(System.in);  
    System.err.println("Enter username");

    String userName = myObj.nextLine();  
    System.err.println("Username is: " + userName); 

  }

}
