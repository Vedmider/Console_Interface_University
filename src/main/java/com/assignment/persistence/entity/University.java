package com.assignment.persistence.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "universities")
@Data
public class University extends BaseEntity {

    @Column
    private String name;

}
