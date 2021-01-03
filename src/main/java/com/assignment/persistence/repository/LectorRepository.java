package com.assignment.persistence.repository;

import com.assignment.persistence.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Integer> {

    @Override
    List<Lector> findAll();

    List<Lector> findLectorByFirstNameContainingOrLastNameContaining(
            String firstNameContains,
            String lastNameContains
    );

}
