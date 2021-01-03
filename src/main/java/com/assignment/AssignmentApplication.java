package com.assignment;

import com.assignment.management.UniversityManager;
import com.assignment.persistence.entity.Lector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class AssignmentApplication implements CommandLineRunner {
    private static Logger LOG = LoggerFactory.getLogger( AssignmentApplication.class );
    private static final String WHO_IS_HEAD_OF_DEP = "(?i)Who.*is.*head.*of.*department.*";
    private static final String SHOW_STATISTICS = "(?i)Show.*statistics.*";
    private static final String SHOW_AVG_DEP_SALARY = "(?i)Show.*the.*average.*salary.*for.*the.*department.*";
    private static final String SHOW_EMPLOYEE_COUNT = "(?i)Show.*count.*of.*employee.*for.*";
    private static final String GLOBAL_SEARCH = "(?i)Global.*search.*by.*";

    @Autowired
    private UniversityManager manager;

    public static void main( String[] args ) {
        SpringApplication.run( AssignmentApplication.class, args );
    }

    @Override
    @Transactional
    public void run( String... args ) throws Exception {
        System.out.println( "Program start...." );
        String query = "";
        Scanner scanner = new Scanner( System.in );

        while ( scanner.hasNext() ) {
            query = scanner.nextLine();
            processRequest( query );
        }
    }

    private void processRequest( String query ) {
        LOG.info( "processing console input : query - " + query );
        String searchQuery;
        if ( query.matches( WHO_IS_HEAD_OF_DEP ) ) {
            searchQuery = extractSubstringByRegex( query, "(?<=department).*" );
            manager.showDepartmentHead( searchQuery );
        } else if ( query.matches( SHOW_STATISTICS ) ) {
            searchQuery = extractSubstringByRegex( query, "(?i)(?<=show).*(?=statistics)" );
            manager.showDepartmentStatistic( searchQuery );
        } else if ( query.matches( SHOW_AVG_DEP_SALARY ) ) {
            searchQuery = extractSubstringByRegex( query, "(?<=department).*" );
            manager.showAverageSalary( searchQuery );
        } else if ( query.matches( SHOW_EMPLOYEE_COUNT ) ) {
            searchQuery = extractSubstringByRegex( query, "(?i)(?<=for).*" );
            manager.countEmployeeOfDepartment( searchQuery );
        } else if ( query.matches( GLOBAL_SEARCH ) ) {
            searchQuery = extractSubstringByRegex( query, "(?i)(?<=by).*" );
            manager.showGlobalSearchResults( searchQuery );
        }
    }

    private String extractSubstringByRegex( String sourceString, String regex ) {
        Pattern pattern = Pattern.compile( regex );
        Matcher matcher = pattern.matcher( sourceString );
        if ( matcher.find() ) {
            return matcher.group().trim();
        }
        return "";
    }
}
