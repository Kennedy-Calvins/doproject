package com.example.doproject.controller;

import com.example.doproject.models.Subscriber;
import com.example.doproject.services.SubscriberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "subscribers")
public class SubscriberController {

    private final SubscriberService subscriberService;

    public SubscriberController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @GetMapping
    public List<Subscriber> findAll(){return subscriberService.findAll();}

    @PostMapping
    public Subscriber createUser(@RequestBody Subscriber subscriber){
        return subscriberService.createUser(subscriber);
    }
    @PatchMapping
    public Subscriber update(@RequestBody Subscriber subscriber){
        return  subscriberService.update(subscriber);
    }

    @GetMapping(value = "{id}")
    public Subscriber findByIdNumber(@PathVariable Integer id){
        return subscriberService.findByIdNumber(id);
    }
}
