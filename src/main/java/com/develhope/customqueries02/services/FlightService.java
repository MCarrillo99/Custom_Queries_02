package com.develhope.customqueries02.services;

import com.develhope.customqueries02.entities.Flight;
import com.develhope.customqueries02.utilities.StatusEnum;
import com.develhope.customqueries02.repositories.FlightsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Service
public class FlightService {

    @Autowired
    private FlightsRepo flightRepo;

    /**
     * this method allows to generate a series of flights using the generateString() for set the values
     * @param n is the number of flights that will be generated
     */
    public void randomCreate(int n){
        for (int i = 0; i < n; i++) {
            Flight flight = new Flight(generateString(), generateString(), generateString(), randomStatusEnumValue());
            List<Flight> flights = new ArrayList<>();
            flights.add(flight);
            flightRepo.saveAllAndFlush(flights);
        }
    }

    /**
     * this method generates a random 10 letters String
     * @return 10 letters String
     */
    private String generateString(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

    /**
     * this method generates a random status value
     * @return a random status value
     */
    private StatusEnum randomStatusEnumValue(){
        StatusEnum randomStatus = null;
        StatusEnum[] status = StatusEnum.values();
        Random rd = new Random();
        int randomNumber = rd.nextInt(status.length);
        for (int i = 0; i <= randomNumber; i++){
            randomStatus = status[i];
        }
        return randomStatus;
    }
}
