package com.example.demo.backend;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Student {
    
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String Name ;

    private String Group ;

    private String Email ;

    private LocalDate Date ;

    // public Long getId() {
    //     return id ;
    // }

    // public void setId(Long id) {
    //     this.id = id ;
    // }
    
    // public String getName() {
    //     return Name ;
    // }

    // public void setName(String Name) {
    //     this.Name = Name ;
    // }

    // public String getGroup() {
    //     return Group ;
    // }

    // public void setGroup(String Group) {
    //     this.Group = Group ;
    // }

    // public String getEmail() {
    //     return Email ;
    // }

    // public void setEmail(String Email) {
    //     this.Email = Email ;
    // }

    // public LocalDate getDate() {
    //     return Date ;
    // }

    // public void setDate(LocalDate Date) {
    //     this.Date = Date ;
    // }

}
