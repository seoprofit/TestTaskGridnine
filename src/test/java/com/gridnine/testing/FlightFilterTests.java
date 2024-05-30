package com.gridnine.testing;


import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FlightFilterTests {

    private List<Flight> flightList = FlightsLoad.createFlights();
    private FlightFilterImpl flightFilter = new FlightFilterImpl(flightList);

    @Test
    public void getAllFlightsTest() {
        Assert.assertEquals(6, flightFilter.getAllFlights().size());
    }

    @Test
    public void getAllFlightsUpToNowTest() {
        Assert.assertEquals(0, flightFilter.getAllFlightsUpToNow(flightList).size());
    }

    @Test
    public void getAllFlightsMoreTwoHoursLongTest() {
        Assert.assertEquals(2, flightFilter.getAllFlightsMoreTwoHoursLong(flightList).size());
    }

    @Test
    public void getAllFlightsBeforeDepartureTest() {
        Assert.assertEquals(2, flightFilter.getAllFlightsBeforeDeparture(flightList).size());
    }


}
