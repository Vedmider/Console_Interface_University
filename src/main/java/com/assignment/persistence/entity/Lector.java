package com.assignment.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import javax.xml.stream.FactoryConfigurationError;
import java.util.List;
import java.util.Set;

@Entity
@Table( name = "lectors",
        uniqueConstraints = {
                @UniqueConstraint( columnNames = { "first_name", "last_name" } )
        } )
@Data
public class Lector extends BaseEntity {
    @Column( name = "first_name" )
    private String firstName;

    @Column( name = "last_name" )
    private String lastName;

    @Column
    private Integer salary;

    @ManyToOne
    @JoinColumn( name = "university_id" )
    private University university;

    @Enumerated
    private Degree degree;

    @ManyToMany( fetch = FetchType.LAZY )
    @JoinTable( name = "lector_department",
                joinColumns = { @JoinColumn( name = "lector_id" ) },
                inverseJoinColumns = { @JoinColumn( name = "department_id" ) }
    )
    private List<Department> departments;

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
