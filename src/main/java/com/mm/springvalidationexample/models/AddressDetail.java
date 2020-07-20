package com.mm.springvalidationexample.models;

import lombok.Data;

@Data
public class AddressDetail {

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private int postalCode;
}