package com.natalie.demoApp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Event {
    @Id//state that the mbrNo is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//generate new primary key value each time a new member entity persisted
    private Long evtNo;

    private String evtName;

    @ManyToMany(mappedBy = "events",cascade = CascadeType.ALL)
    //use the mappedBy attribute to tell Hibernate that this relationship has already been defined and configured in the Member class.
    //It helps Hibernate understand that this is the inverse side of the relationship and that the association should be managed by the other entity.
    private Set<Member> members;
}
