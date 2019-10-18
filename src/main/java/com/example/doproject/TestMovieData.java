package com.example.doproject;

import com.example.doproject.models.MovieClassification;
import com.example.doproject.models.Movie;
import com.example.doproject.models.Subscriber;
import com.example.doproject.models.Type;
import com.example.doproject.repositories.MovieClassificationRepository;
import com.example.doproject.repositories.MovieRepository;
import com.example.doproject.repositories.TypeRepository;
import com.example.doproject.repositories.SubscriberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestMovieData implements CommandLineRunner {
    private final SubscriberRepository subscriberRepository;
    private final TypeRepository typeRepository;
    private final MovieClassificationRepository movieClassificationRepository;
    private  final MovieRepository movieRepository;



    public TestMovieData(SubscriberRepository subscriberRepository, TypeRepository typeRepository, MovieClassificationRepository movieClassificationRepository, MovieRepository movieRepository) {
        this.subscriberRepository = subscriberRepository;
        this.typeRepository = typeRepository;
        this.movieClassificationRepository = movieClassificationRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Subscriber netflix = new Subscriber("Netflix",95093);
        subscriberRepository.save(netflix);

        Type Original = new Type("Original");
        typeRepository.save(Original);

        Type Suggested = new Type("Suggested");
        typeRepository.save(Suggested);

        MovieClassification animation = new MovieClassification("Animation");
        movieClassificationRepository.save(animation);

        MovieClassification drama = new MovieClassification("Drama");
        movieClassificationRepository.save(drama);

        MovieClassification cartoon = new MovieClassification("Cartoon");
        movieClassificationRepository.save(cartoon);

        Movie IpMan = new Movie("Boss Baby", "Mtoi", Original,animation, netflix);
        movieRepository.save(IpMan);

        Movie Madagascar = new Movie("Everybody hates Chris", "Chris", Original,drama, netflix);
        movieRepository.save(IpMan);




    }
}
