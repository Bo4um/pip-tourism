package com.example.tourismapi.repository;

import com.example.tourismapi.models.Tourist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristRepository extends CrudRepository<Tourist, Long> {

}
