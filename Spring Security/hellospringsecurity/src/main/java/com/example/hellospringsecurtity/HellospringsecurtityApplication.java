package com.example.hellospringsecurtity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HellospringsecurtityApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellospringsecurtityApplication.class, args);
    }
 @GetMapping("/users")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name){
        return String.format("Hello %s!",name);
 }
}
