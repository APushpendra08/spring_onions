package com.play.reminder.Reminder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

//@RestController
public class StarController {

    private final AtomicInteger id =new AtomicInteger();
    private final String template = "Hello %s";

    @GetMapping("/")
    public String home(){
        return "Hello, Welcome to Home";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name){
        return "Hello " + name;
    }

    @GetMapping("/greetings")
    public Greetings greetings(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greetings(id.getAndIncrement(), String.format(template, name));
    }
}
