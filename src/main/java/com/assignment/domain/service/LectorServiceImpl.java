package com.assignment.domain.service;

import com.assignment.persistence.entity.Lector;
import com.assignment.persistence.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LectorService")
public class LectorServiceImpl implements LectorService {

    private LectorRepository lectorRepository;

    @Autowired
    public LectorServiceImpl(LectorRepository lectorRepository){
        this.lectorRepository = lectorRepository;
    }

    @Override
    public List<Lector> globalSearch( String keyWord ) {
        return lectorRepository.findLectorByFirstNameContainingOrLastNameContaining( keyWord, keyWord );
    }

    public List<Lector> findAll(){
        return lectorRepository.findAll();
    }
}
