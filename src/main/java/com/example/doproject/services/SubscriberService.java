package com.example.doproject.services;

import com.example.doproject.models.Subscriber;

import java.util.List;
import java.util.Optional;

public interface SubscriberService {

    List<Subscriber> findAll();

    Optional<Subscriber> findById(Long id);

    Subscriber createUser(Subscriber subscriber);

    Subscriber update(Subscriber subscriber);

    Subscriber findByIdNumber(Integer id);

}
