package com.example.doproject.services;

import com.example.doproject.models.MovieClassification;
import com.example.doproject.repositories.MovieClassificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieClassificationServiceImpl implements MovieClassificationService {

    private final MovieClassificationRepository movieClassificationRepository;

    public MovieClassificationServiceImpl(MovieClassificationRepository movieClassificationRepository) {
        this.movieClassificationRepository = movieClassificationRepository;
    }


    @Override
    public List<MovieClassification> findAll() {
        return movieClassificationRepository.findAll();
    }

    @Override
    public Optional<MovieClassification> findById(Long id) {
        return movieClassificationRepository.findById(id);
    }
}
