package com.mm.springvalidationexample.models;

import lombok.Data;

@Data
public class VehPolicy {

    private String policyNbr;
    private Double premium;
    private String typeCd;
}
