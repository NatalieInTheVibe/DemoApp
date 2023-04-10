package com.natalie.demoApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data//the data annotation of Lombok will generate the methods for all fields in the class
//setter getter NoArgsConstructor AllArgsConstructor
@Entity//telling JPA to map the class to a database table, and to create a corresponding schema for the table.
//table name will be member, same as the name of the entity class annotated with @Entity
public class Member {

    @Id//state that the mbrNo is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//generate new primary key value each time a new member entity persisted
    private Integer mbrNo;

    private String mbrName;
    private String mbrTier;
    private String mbrSex;
}
