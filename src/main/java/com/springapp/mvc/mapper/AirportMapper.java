package com.springapp.mvc.mapper;

import com.springapp.mvc.Airport;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by urandu on 6/12/15.
 */
public class AirportMapper implements RowMapper<Airport> {
    @Override
    public Airport mapRow(ResultSet resultSet, int i) throws SQLException {
        Airport airport=new Airport();
        airport.setLatitude(resultSet.getDouble("Latitude"));
        airport.setLongitude(resultSet.getDouble("Longitude"));
        airport.setCity(resultSet.getString("City"));
        airport.setCode(resultSet.getString("Code"));
        return airport;
    }
}
