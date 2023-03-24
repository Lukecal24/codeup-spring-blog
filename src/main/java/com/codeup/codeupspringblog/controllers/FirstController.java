package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {

    @GetMapping("/hello")
        @ResponseBody
    public String returnHelloWorld(){
         return "Hello World";
     }

     @GetMapping("/hello/{name}")
        @ResponseBody
    public String returnHelloName(@PathVariable String name) {
         return "Hello " + name;
     }

    @GetMapping("/hello/{fname}/{lname}")
    @ResponseBody
    public String returnHelloName(@PathVariable String fname, @PathVariable String lname) {
        return "Hello " + fname + " " + lname;
    }

    @GetMapping("/luke")
        @ResponseBody
    public String returnLuke(){
         return "<h1> Hello Luke </h1>";
     }

}
