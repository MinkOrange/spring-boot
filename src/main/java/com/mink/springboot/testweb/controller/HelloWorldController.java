package com.mink.springboot.testweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/springboot")
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index(){
        return "Hello World";
    }

    @RequestMapping(value = "/getUserByGet", method = RequestMethod.GET)
    String getUserByGet(@RequestParam(value = "userName") String userName){
        return "Hello " + userName;
    }

    @RequestMapping(value = "/getUserByPost", method = RequestMethod.POST)
    String getUserByPost(@RequestParam(value = "userName") String userName){
        return "Hello " + userName;
    }
}
