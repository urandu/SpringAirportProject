package com.springapp.mvc.dao;

import com.springapp.mvc.ZipCode;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by urandu on 6/12/15.
 */
public interface ZipCodeDAO {

    public void setDataSource(DataSource ds);


    public List<ZipCode> getAllZipCodes();
    public List<ZipCode> getAllCityZipCodes(String city);
    public ZipCode getZipCode(Integer zip);
}
