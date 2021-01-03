package com.assignment.persistence.repository;

import com.assignment.persistence.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Department findByNameIgnoreCase( String departmentName );

    @Query( "select concat( d.departmentHead.firstName, ' ', d.departmentHead.lastName)  from Department d where lower(d.name) = lower(:department_name)" )
    String findDepartmentHeadByNameIgnoreCase( @Param( "department_name" ) String departmentName );

    @Query( "select avg (l.salary) from Department d join d.lectors l where d.name = :name" )
    Integer findAverageDepartmentSalary( @Param( "name" ) String departmentName );

    @Query( "select count(l) from Department d join d.lectors l where lower(d.name) = lower(:department_name)" )
    Integer countAllDepartmentEmployee( @Param( "department_name" ) String departmentName );
}
