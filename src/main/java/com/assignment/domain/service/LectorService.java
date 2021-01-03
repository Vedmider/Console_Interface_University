package com.assignment.domain.service;

import com.assignment.persistence.entity.Lector;

import java.util.List;

public interface LectorService {

    List<Lector> globalSearch(String keyWord);

    List<Lector> findAll();
}
