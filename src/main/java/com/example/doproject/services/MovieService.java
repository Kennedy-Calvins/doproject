package com.example.doproject.services;

import com.example.doproject.models.Movie;

import java.util.List;
import java.util.Optional;


public interface MovieService {

    List<Movie> findAll();

    List<Movie> search(String name);

    Movie createMovie(Movie movie);

    Movie update(Movie movie);

    Optional<Movie> findById(Long id);

    void delete(Long id);

}
