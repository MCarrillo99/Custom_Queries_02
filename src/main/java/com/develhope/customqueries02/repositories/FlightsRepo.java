package com.develhope.customqueries02.repositories;

import com.develhope.customqueries02.entities.Flight;
import com.develhope.customqueries02.utilities.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightsRepo extends JpaRepository<Flight, Long> {

    List<Flight> findByStatus(StatusEnum status);


}
