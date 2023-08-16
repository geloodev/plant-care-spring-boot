package com.geloodev.plantcarespringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a")
public class A {
    
    @GetMapping
    public String[] getPlants() {
        String[] plants = {"a", "b"};
        return plants;
    }
}
