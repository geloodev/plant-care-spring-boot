package com.geloodev.plantcarespringboot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    int id;
    String common_name;
    String slug;
    String scientific_name;
    int year;
}