package com.example.doproject.services;

import com.example.doproject.models.Type;

import java.util.List;
import java.util.Optional;

public interface TypeService {

    List<Type> findAll();

    Optional<Type> findById(Long id);
}
