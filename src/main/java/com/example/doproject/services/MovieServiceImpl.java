package com.example.doproject.services;

import com.example.doproject.models.Movie;
import com.example.doproject.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> search(String name) {
        return movieRepository.findByNameContaining(name);
    }

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie update(Movie movie) {
        Optional<Movie> found = findById(movie.getId());
        if(found.isPresent()){
            Movie toedit = found.get();

            toedit.setActor(movie.getActor());
            toedit.setMovieClassification(movie.getMovieClassification());
            toedit.setName(movie.getName());
            toedit.setType(movie.getType());
            toedit.setSubscriber(movie.getSubscriber());


            return movieRepository.save(toedit);

        }

        return null;


    }

    @Override
    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);

    }
}
