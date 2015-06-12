package com.springapp.mvc.template;

import com.springapp.mvc.ZipCode;
import com.springapp.mvc.dao.ZipCodeDAO;
import com.springapp.mvc.mapper.ZipCodeMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by urandu on 6/12/15.
 */
public class ZipCodeJDBCTemplate implements ZipCodeDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public List<ZipCode> getAllZipCodes() {

        String SQL = "select * from `zipcodes` ";
        List <ZipCode> zipCodes = jdbcTemplateObject.query(SQL,
                new ZipCodeMapper());
        return zipCodes;
    }

    @Override
    public List<ZipCode> getAllCityZipCodes(String city) {



        String SQL = "select * from `zipcodes` where `city` =" + city;
        List <ZipCode> zipCodes = jdbcTemplateObject.query(SQL,
                new ZipCodeMapper());
        return zipCodes;

    }

    @Override
    public ZipCode getZipCode(Integer zip) {
        String SQL = "select * from `zipcodes` where `zip` =" + zip;
        ZipCode zipCode=jdbcTemplateObject.queryForObject(SQL,
                new Object[]{zip}, new ZipCodeMapper());
        return zipCode;
    }
}
