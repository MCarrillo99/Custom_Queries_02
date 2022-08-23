package com.develhope.customqueries02.entities;

import com.develhope.customqueries02.utilities.StatusEnum;

import javax.persistence.*;

@Entity
@Table
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String description;

    private String fromAirport;

    private String toAirportort;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    public Flight() {
    }

    public Flight(String description, String fromAirport, String toAirportort, StatusEnum status) {
        this.description = description;
        this.fromAirport = fromAirport;
        this.toAirportort = toAirportort;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getToAirportort() {
        return toAirportort;
    }

    public void setToAirportort(String toAirportort) {
        this.toAirportort = toAirportort;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
