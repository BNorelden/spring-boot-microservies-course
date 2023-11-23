package com.bncode.springbootdemo.controller;

//import org.springframework.stereotype.Controller;

import com.bncode.springbootdemo.model.User;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.ResponseBody;


//@Controller
//@ResponseBody
@RestController
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "Hello World";
    }

    //    ***endpoints used*** //more
    //    http://localhost:8080/
    //    http://localhost:8080/user
    //    http://localhost:8080/1/abc
    //    http://localhost:8080/actuator/health
    //    http://localhost:8080/actuator

    //    @RequestMapping(value = "/user", method = RequestMethod.GET) // Old way of using RequestMapping
    @GetMapping("/user") //this is uri
    public User user() {
        User user = new User();
        user.setId("1");
        user.setName("Bob");
        user.setEmailId("Bob@comp.com");
        return user;
    }

    /*    @GetMapping("/{id}")
    public String pathVariable(@PathVariable String id){
        return "The Path Variable is " + id + " " + name;
    }*/

    @GetMapping("/{id}/{id2}")
    public String pathVariable(@PathVariable String id,
                               @PathVariable("id2") String name) {
        return "The Path Variable is " + id + " " + name;
    }

    @GetMapping("/requestParam")
    public String requestParams(@RequestParam String name,
                                @RequestParam(name = "email", required = false, defaultValue = "") String emailId) { //defaultValue empty instead of null
        return "Your Name is: " + name + " and EmailId is: " + emailId;

    }
}