package com.example.doproject.services;

import com.example.doproject.models.MovieClassification;

import java.util.List;
import java.util.Optional;

public interface MovieClassificationService {

    List<MovieClassification> findAll();

    Optional<MovieClassification> findById(Long id);

}
