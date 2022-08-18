package com.develhope.customqueries02.repositories;

import com.develhope.customqueries02.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightsRepo extends JpaRepository<Flight, Long> {


}
