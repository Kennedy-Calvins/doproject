package com.example.doproject.repositories;

import com.example.doproject.models.MovieClassification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieClassificationRepository extends JpaRepository<MovieClassification, Long> {
}
