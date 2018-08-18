package com.trailer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Nageswar on 8/18/2018.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/index")
    public String homePage(){
        System.out.println("*** Index *** ");
        return "index";
    }
}
