package com.assignment.domain.service;

import com.assignment.persistence.entity.Department;
import com.assignment.persistence.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service( "DepartmentService" )
public class DepartmentServiceImpl implements DepartmentService {
    private static final Logger LOG = LoggerFactory.getLogger( DepartmentService.class );

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl( DepartmentRepository departmentRepository ) {
        this.departmentRepository = departmentRepository;
    }

    public Department findByName( String departmentName ) {
        LOG.info( "Trying to get department from database by its name - {}", departmentName );
        return departmentRepository.findByNameIgnoreCase( departmentName );
    }

    public String findDepartmentHeadByName( String departmentName ) {
        LOG.info( "Trying to get department head by name - {}", departmentName );
        return departmentRepository.findDepartmentHeadByNameIgnoreCase( departmentName );
    }

    public Integer findAverageDepartmentSalary( String departmentName ) {
        LOG.info( "Trying to get average department {} salary from database", departmentName );
        return departmentRepository.findAverageDepartmentSalary( departmentName );
    }

    public Integer countAllDepartmentEmployee( String departmentName ) {
        LOG.info( "Trying to get department {} employ count from database", departmentName );
        return departmentRepository.countAllDepartmentEmployee( departmentName );
    }

}
