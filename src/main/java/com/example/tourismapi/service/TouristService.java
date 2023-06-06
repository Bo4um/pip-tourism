package com.example.tourismapi.service;

import com.example.tourismapi.models.Tourist;

import java.util.List;
import java.util.Optional;

public interface TouristService {
    Optional<Tourist> read(Long id);
    List<Tourist> readAll();
    void create(Tourist tourist);
    void update(Tourist tourist);
    void delete(Long id);
}
