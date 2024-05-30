package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilterImpl flightFilter = new FlightFilterImpl(flights);
        System.out.println("All flights: " + flightFilter.getAllFlights());
        System.out.println("All flights up to now: " + flightFilter.getAllFlightsUpToNow(flights));
        System.out.println("All flights more then 2 hours long: " + flightFilter.getAllFlightsMoreTwoHoursLong(flights));
        System.out.println("All flights before departure: " + flightFilter.getAllFlightsBeforeDeparture(flights));
    }
}
