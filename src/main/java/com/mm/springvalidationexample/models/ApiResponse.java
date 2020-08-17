package com.mm.springvalidationexample.models;

import lombok.Data;

@Data
public class ApiResponse {

    private String policyNbr;
    private String typeCd;
    private double premium;
    private PersonView namedInsured;
    private PersonView spouse;
}
