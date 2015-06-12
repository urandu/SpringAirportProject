package com.springapp.mvc.template;

import com.springapp.mvc.Airport;
import com.springapp.mvc.dao.AirportDAO;
import com.springapp.mvc.mapper.AirportMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by urandu on 6/12/15.
 */
public class AirportJDBCTemplate implements AirportDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Airport> listNearestAirports(Double latitude, Double longitude, Integer distance) {


        String SQL = "SELECT Code,Latitude,Longitude, City, SQRT(" +
                "    POW(69.1 * (Latitude - "+latitude+"), 2) +" +
                "    POW(69.1 * ("+longitude+" - Longitude) * COS(Latitude / 57.3), 2)) AS distance" +
                "FROM airports HAVING distance < "+distance+" " +
                "ORDER BY `distance`  ASC ";
        List <Airport> airports = jdbcTemplateObject.query(SQL,
                new AirportMapper());
        return airports;


    }
}
