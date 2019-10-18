package com.example.doproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @NotNull(groups = Update.class)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull(groups = Create.class)
    private String name;

    @Column(name = "actor")
    @NotNull(groups = Create.class)
    private String actor;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="type_id")
    private Type type;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="category_id")
    private MovieClassification movieClassification;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="owner_id")
    private Subscriber subscriber;

    @ManyToMany(mappedBy = "movieSet")
    Set<MovieClassification> movieClassificationSet;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public MovieClassification getMovieClassification() {
        return movieClassification;
    }

    public void setMovieClassification(MovieClassification movieClassification) {
        this.movieClassification = movieClassification;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public Movie(String name, String actor, Type type, MovieClassification movieClassification, Subscriber subscriber) {
        this.name = name;
        this.actor = actor;
        this.type = type;
        this.movieClassification = movieClassification;
        this.subscriber = subscriber;
    }

    public Movie(){}

    public interface Create{}
    public interface  Update{}




}
