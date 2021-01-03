package com.assignment.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table( name = "departments" )
@Data
public class Department extends BaseEntity {
    @Column( name = "department_name" )
    private String name;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "lector_id" )
    private Lector departmentHead;

    @ManyToMany(mappedBy = "departments")
    private List<Lector> lectors;

    @Override
    public String toString() {
        return name;
    }
}
