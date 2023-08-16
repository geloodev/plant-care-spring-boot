package com.geloodev.plantcarespringboot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Plant { 
    
    Data data;

    public Plant(Data data) {
        this.data = data;
    }

    public Plant() {}
}