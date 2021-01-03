package com.assignment.domain.service;

import com.assignment.persistence.entity.Department;

public interface DepartmentService {

    Department findByName( String departmentName );

    String findDepartmentHeadByName( String departmentName );

    Integer findAverageDepartmentSalary( String departmentName );

    Integer countAllDepartmentEmployee( String departmentName );
}
