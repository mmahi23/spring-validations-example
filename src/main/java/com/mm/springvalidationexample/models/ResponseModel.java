package com.mm.springvalidationexample.models;

import lombok.Data;

import java.util.List;

@Data
public class ResponseModel {

    private VehPolicy vehPolicy;
    private List<Person> persons;

}
