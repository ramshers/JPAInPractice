/**
 * 
 */
package com.example.demo.entitymodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author vamsheek
 *
 */
@Entity  
@Table(name = "billionaires")
public class Person {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;
  
  @Column(name="fist_name")
  String firstName;
  
  @Column(name="last_name")
  String lastName;
  
  String career;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getCareer() {
    return career;
  }

  public void setCareer(String career) {
    this.career = career;
  }

  @Override
  public String toString() {
    return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", career="
        + career + "]";
  }

}
