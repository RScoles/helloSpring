package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller

public class HelloController {

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello";
    }

    //Handles requests of the form /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //Handles requests of the form /hello?name=LaunchCode&language=English
    @GetMapping("hello/name")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
        String properGreeting = createMessage(name, language);
        return properGreeting;
    }

    @GetMapping("form")
    public String helloForm(){
        return "form";
    }
    @ResponseBody
    public static String createMessage(String name, String language) {
        switch(language){
            case "Spanish" :
                return "Hola, " + name;
            case "French":
                return  "Bonjour, " + name;
            case "Italian":
                return "Ciao, " + name;
            case "German":
                return "Hallo, " + name;
            case"English" :
            default:
                return "Hello, " + name;
        }

        }
    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }
}
