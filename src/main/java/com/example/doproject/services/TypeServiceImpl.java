package com.example.doproject.services;

import com.example.doproject.models.Type;
import com.example.doproject.repositories.TypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class TypeServiceImpl implements  TypeService{
    private  final TypeRepository typeRepository;

    public TypeServiceImpl(TypeRepository typeRepository) {

        this.typeRepository = typeRepository;
    }

    @Override
    public List<Type> findAll()
    {
        return typeRepository.findAll();
    }

    @Override
    public Optional<Type> findById(Long id) {

        return typeRepository.findById(id);
    }
}
