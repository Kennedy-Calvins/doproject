package com.example.doproject.repositories;

import com.example.doproject.models.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SubscriberRepository extends JpaRepository<Subscriber, Long > {

    Subscriber findByIdNumber(Integer idNumber);
}
