package com.example.doproject.controller;


import com.example.doproject.models.MovieClassification;
import com.example.doproject.services.MovieClassificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "classification")
public class MovieClassificationController {

    private final MovieClassificationService movieClassificationService;

    public MovieClassificationController(MovieClassificationService movieClassificationService) {

        this.movieClassificationService = movieClassificationService;
    }

    @GetMapping
    public List<MovieClassification> findAll(){

        return movieClassificationService.findAll();
    }

    @GetMapping(value = "{id}")
    public Optional<MovieClassification> findById(@PathVariable Long id){

        return movieClassificationService.findById(id);
    }


}
