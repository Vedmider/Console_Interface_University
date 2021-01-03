package com.assignment.management;

import com.assignment.domain.service.DepartmentService;
import com.assignment.domain.service.LectorService;
import com.assignment.persistence.entity.Degree;
import com.assignment.persistence.entity.Department;
import com.assignment.persistence.entity.Lector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UniversityManager {

    private DepartmentService departmentService;
    private LectorService lectorService;

    @Autowired
    public UniversityManager(
            DepartmentService departmentService,
            LectorService lectorService
    ) {
        this.departmentService = departmentService;
        this.lectorService = lectorService;
    }

    public void showDepartmentStatistic( String departmentName ) {
        List<Lector> lectors = departmentService.findByName( departmentName ).getLectors();

        long assistanceCount = lectors.stream()
                                      .filter( lector -> lector.getDegree()
                                                               .equals( Degree.ASSISTANT ) )
                                      .count();
        long associateProfessorsCount = lectors.stream()
                                               .filter( lector -> lector.getDegree()
                                                                        .equals( Degree.ASSOCIATE_PROFESSOR ) )
                                               .count();
        long professorsCount = lectors.stream()
                                      .filter( lector -> lector.getDegree()
                                                               .equals( Degree.PROFESSOR ) )
                                      .count();

        System.out.println( "assistans - " + assistanceCount );
        System.out.println( "associate professors - " + associateProfessorsCount );
        System.out.println( "professors -" + professorsCount );

    }

    public void showDepartmentHead( String departmentName ) {
        String departmentHeadName = departmentService.findDepartmentHeadByName( departmentName );
        System.out.printf( "Head of %s department is %s%n", departmentName, departmentHeadName );
    }

    public void showAverageSalary( String departmentName ) {
        long avgSalary = departmentService.findAverageDepartmentSalary( departmentName );
        System.out.printf( "The average salary of %s is %d", departmentName, avgSalary );
    }

    public void countEmployeeOfDepartment( String departmentName ) {
        long employeeCount = departmentService.countAllDepartmentEmployee( departmentName );
        System.out.println( employeeCount );
    }

    public void showGlobalSearchResults( String keyWord ) {
        List<Lector> lectors = lectorService.globalSearch( keyWord );
        Lector lector;
        int size = lectors.size();

        for ( int i = 0; i < size; i++ ) {
            lector = lectors.get( i );
            System.out.print( lector.getFirstName() + " " + lector.getLastName() );
            if ( i < size - 1 ) {
                System.out.print( ", " );
            } else {
                System.out.println( "." );
            }
        }
    }
}
