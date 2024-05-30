package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlightFilterImpl implements FlightFilter {

    private List<Flight> flights;

    public FlightFilterImpl(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public List<Flight> getAllFlights() {
        return flights;
    }

    @Override
    public List<Flight> getAllFlightsUpToNow(List<Flight> flights) {
        return flights.stream().filter(flight -> flight.getSegments().stream().anyMatch(segment -> segment.getDepartureDate().isBefore(LocalDateTime.now()))).collect(Collectors.toList());
    }

    @Override
    public List<Flight> getAllFlightsMoreTwoHoursLong(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {
                    List<Segment> segments = flight.getSegments();
                    return IntStream.range(0, segments.size() - 1)
                            .anyMatch(i -> {
                                LocalDateTime departure = segments.get(i + 1).getDepartureDate();
                                LocalDateTime arrival = segments.get(i).getArrivalDate();
                                return departure.isAfter(arrival.plusHours(2));
                            });
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> getAllFlightsBeforeDeparture(List<Flight> flights) {
        return flights.stream().filter(flight -> flight.getSegments().stream().anyMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate()))).collect(Collectors.toList());

    }


}
