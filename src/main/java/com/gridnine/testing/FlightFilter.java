package com.gridnine.testing;

import java.util.List;

public interface FlightFilter {

    List<Flight> getAllFlights();

    List<Flight> getAllFlightsUpToNow(List<Flight> flights);

    List<Flight> getAllFlightsMoreTwoHoursLong(List<Flight> flights);

    List<Flight> getAllFlightsBeforeDeparture(List<Flight> flights);

}


