package com.example.doproject.services;

import com.example.doproject.models.Subscriber;
import com.example.doproject.repositories.SubscriberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SubscriberServiceImpl implements SubscriberService {

    private final SubscriberRepository subscriberRepository;

    public SubscriberServiceImpl(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    @Override
    public List<Subscriber> findAll() {
        return subscriberRepository.findAll();
    }

    @Override
    public Optional<Subscriber> findById(Long id) {
        return subscriberRepository.findById(id);
    }

    @Override
    public Subscriber createUser(Subscriber subscriber) {
        return subscriberRepository.save(subscriber);
    }

    @Override
    public Subscriber update(Subscriber subscriber) {

        Optional<Subscriber> found = findById(subscriber.getId());

        if(found.isPresent()){
            Subscriber toedit = found.get();

            toedit.setIdNumber(subscriber.getIdNumber());
            toedit.setName(subscriber.getName());

            subscriberRepository.save(toedit);
        }

        return  null;
    }

    @Override
    public Subscriber findByIdNumber(Integer id) {
        return subscriberRepository.findByIdNumber(id);
    }
}
