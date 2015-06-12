package com.springapp.mvc.dao;

import com.springapp.mvc.Airport;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by urandu on 6/12/15.
 */
public interface AirportDAO {



    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    public void setDataSource(DataSource ds);


    public List<Airport> listNearestAirports(Double latitude,Double longitude,Integer distance);



}
