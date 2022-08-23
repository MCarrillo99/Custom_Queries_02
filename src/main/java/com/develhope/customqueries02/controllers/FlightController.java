package com.develhope.customqueries02.controllers;

import com.develhope.customqueries02.entities.Flight;
import com.develhope.customqueries02.utilities.StatusEnum;
import com.develhope.customqueries02.repositories.FlightsRepo;
import com.develhope.customqueries02.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.apache.coyote.http11.Constants.a;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightsRepo flightsRepo;

    @Autowired
    private FlightService flightService;

    /**
     * this method uses randomCreate() for generates a number of flights.
     * If the @RequiredParam is absent the default number is 100
     * @param m is the number of flights that will be generated
     */
    @PostMapping
    public void postRandomFlights(@RequestParam(required = false)Optional<Integer> m){
        int n;
        if (m.isEmpty()){
            n = 100;
        }else n = m.get();
        flightService.randomCreate(n);
    }

    /**
     * this method allows to have a list of all flights ordered by the variable "fromAirport"
     * @param page
     * @param size of the page
     * @return a Page of flights
     */
    @GetMapping("/all")
    public Page<Flight> getAllFlights(@RequestParam int page, @RequestParam int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("fromAirport").ascending());
        Page<Flight> flightsPage = flightsRepo.findAll(pageable);
        return flightsPage;
    }

    /**
     * this method allows to find all flights that have a status ONTIME
     * @return all flights with status ONTIME
     */
    @GetMapping("/on_time")
    public List<Flight> getFlightsOnTime(){
        List<Flight> flights = flightsRepo.findByStatus(StatusEnum.ONTIME);
        return flights;
    }

    /**
     * this method allows to find all flights that have a status with params p1 and p2
     * @param p1 it must be a param of StatusEnum
     * @param p2 it must be  a param of StatusEnum
     * @return a list of all flight that have p1 and p2 as status
     */
    @GetMapping("/researched_status")
    public List<Flight> get2TypeOfStatus(@RequestParam StatusEnum p1, StatusEnum p2){
        List<Flight> flights01 = flightsRepo.findByStatus(p1);
        List<Flight> flights02 = flightsRepo.findByStatus(p2);
        flights01.addAll(flights02);
        flights01.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));
        return flights01;
    }

}
