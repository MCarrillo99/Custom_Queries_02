package com.develhope.customqueries02.controllers;

import com.develhope.customqueries02.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {

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

}
