package com.springapp.mvc;

import com.springapp.mvc.template.AirportJDBCTemplate;
import com.springapp.mvc.template.ZipCodeJDBCTemplate;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/")
public class CareercupController {
    @InitBinder
    private void dateBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, editor);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");
        AirportJDBCTemplate questionsJDBCTemplate =
                (AirportJDBCTemplate)context.getBean("airportJDBCTemplate");







        model.addAttribute("command");

        return "airportsWithinZipCode";
    }







    @RequestMapping(value = "/airportsWithinZipCode", method = RequestMethod.GET)
    public String airportsWithinZipCode(@ModelAttribute("zip_code")Integer zip_code,
                                        @ModelAttribute("distance")Integer distance,
                                ModelMap model) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");

        ZipCodeJDBCTemplate zipCodeJDBCTemplate=(ZipCodeJDBCTemplate) context.getBean("zipCodeJDBCTemplate");
        AirportJDBCTemplate airportJDBCTemplate=(AirportJDBCTemplate) context.getBean("airportJDBCTemplate");

        ZipCode zipCode =zipCodeJDBCTemplate.getZipCode(zip_code);

        if(!zipCode.equals(null))
        {
            Double lat=zipCode.getLatitude();
            Double lon=zipCode.getLongitude();
            model.addAttribute("airports", airportJDBCTemplate.listNearestAirports(lat,lon,distance));



            model.addAttribute("zip_code",zip_code);

            return "airportsWithinZipCode";

        }

        return "errorPage";
    }

    @RequestMapping(value = "/question1", method = RequestMethod.GET)
    public String question1(ModelMap model) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");


        ZipCodeJDBCTemplate zipCodeJDBCTemplate=(ZipCodeJDBCTemplate) context.getBean("zipCodeJDBCTemplate");
        AirportJDBCTemplate airportJDBCTemplate=(AirportJDBCTemplate) context.getBean("airportJDBCTemplate");


        model.addAttribute("command");

        return "airportsWithinZipCode";


    }








}