package com.assignment.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable {

    @Id
    @Column( unique = true, nullable = false )
    protected int id;

    @Override
    public boolean equals( Object o ) {
        int objId = ( (BaseEntity) o ).getId();
        if ( this.id == objId ) {
            return true;
        }

        return false;
    }
}
