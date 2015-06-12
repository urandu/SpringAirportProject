package com.springapp.mvc.mapper;

import com.springapp.mvc.ZipCode;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by urandu on 6/12/15.
 */
public class ZipCodeMapper implements RowMapper<ZipCode> {
    @Override
    public ZipCode mapRow(ResultSet resultSet, int i) throws SQLException {
        ZipCode zipCode=new ZipCode();
        zipCode.setCity(resultSet.getString("city"));
        zipCode.setDst(resultSet.getInt("dst"));
        zipCode.setLatitude(resultSet.getDouble("latitude"));
        zipCode.setLongitude(resultSet.getDouble("longitude"));
        zipCode.setState(resultSet.getString("state"));
        zipCode.setTimeZone(resultSet.getInt("timezone"));
        zipCode.setZip(resultSet.getInt("zip"));

        return zipCode;
    }
}
