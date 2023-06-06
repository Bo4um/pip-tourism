package com.example.tourismapi.service;

import com.example.tourismapi.models.Tourist;
import com.example.tourismapi.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristServiceImpl implements TouristService{

    private final TouristRepository repository;

    @Autowired
    public TouristServiceImpl(TouristRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Tourist> read(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Tourist> readAll() {
        return (List<Tourist>) repository.findAll();
    }

    @Override
    public void create(Tourist tourist) {
        repository.save(tourist);
    }

    @Override
    public void update(Tourist tourist) {
        repository.save(tourist);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
