package com.mm.springvalidationexample.models;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class User {

    //@NotEmpty
    private String name;

    //@NotEmpty
    private String address;

    private AddressDetail addressDetail;
}
