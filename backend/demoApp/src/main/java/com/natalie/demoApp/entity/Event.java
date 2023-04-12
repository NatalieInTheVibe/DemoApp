package com.natalie.demoApp.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "evtNo")

public class Event {
    @Id//state that the mbrNo is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//generate new primary key value each time a new member entity persisted
    private Long evtNo;

    private String evtName;

    @ManyToMany(mappedBy = "events",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    //use the mappedBy attribute to tell Hibernate that this relationship has already been defined and configured in the Member class.
    //It helps Hibernate understand that this is the inverse side of the relationship and that the association should be managed by the other entity.
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Set<Member> members;
}
