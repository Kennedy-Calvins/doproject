package com.example.doproject.controller;

import com.example.doproject.models.Movie;
import com.example.doproject.models.Subscriber;
import com.example.doproject.services.MovieService;
import com.example.doproject.services.SubscriberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "movies")

public class MovieController {

    private final MovieService movieService;
    private final SubscriberService subscriberService;

    public MovieController(MovieService movieService, SubscriberService subscriberService) {
        this.movieService = movieService;
        this.subscriberService = subscriberService;
    }

    @GetMapping
    public List<Movie> findAll(){return movieService.findAll();}

    @GetMapping(value = "search")
    public List<Movie> search(@RequestParam String name){return movieService.search(name);}

    @PostMapping
    public Movie createMovie(
                             @RequestBody Movie movie ,
                             @RequestParam Integer idno)
    {
        Subscriber found =  subscriberService.findByIdNumber(idno);
        if(found.getIdNumber().equals(idno)){
        return movieService.createMovie(movie);
        }
        return null;
    }

    @PatchMapping
    public Movie update(@RequestBody Movie movie , @RequestParam Integer idno){

        Subscriber foundSubscriber =  subscriberService.findByIdNumber(idno);
        Optional<Movie> foundMovie = movieService.findById(movie.getId());

        if(foundMovie.isPresent()) {
            if (foundSubscriber.getId().equals(foundMovie.get().getSubscriber().getId())) {
                return movieService.update(movie);
            }
        }
        return  null;
    }

    @DeleteMapping(value = "{id}")
    public  void delete(@PathVariable Long id,
                        @RequestParam Integer idno){
        Subscriber foundSubscriber =  subscriberService.findByIdNumber(idno);
        Optional<Movie> foundMovie = movieService.findById(id);

        if(foundMovie.isPresent()) {
            if (foundSubscriber.getId().equals(foundMovie.get().getSubscriber().getId())) {
                 movieService.delete(id);
            }
        }
    }
}
