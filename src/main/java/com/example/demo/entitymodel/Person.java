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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "person")
@Getter
@Setter
@ToString
@EqualsAndHashCode()
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;

  @Column(name = "fist_name")
  String firstName;
  
  @Setter
  @Column(name = "last_name")
  String lastName;

  @Column(name = "career")
  String career;

}


