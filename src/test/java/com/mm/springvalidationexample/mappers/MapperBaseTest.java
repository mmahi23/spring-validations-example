package com.mm.springvalidationexample.mappers;

import com.mm.springvalidationexample.models.ApiResponse;
import com.mm.springvalidationexample.models.Person;
import com.mm.springvalidationexample.models.ResponseModel;
import com.mm.springvalidationexample.models.VehPolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MapperBaseTest {

    private ResponseModel mockModel;
    private ApiResponse apiResponse;

    @InjectMocks
    private MapperBaseImpl mapperBase;

    @Spy
    private MapperHelper mapperHelper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockModel = getMockModel();

    }

    private ResponseModel getMockModel()
    {
        ResponseModel model = new ResponseModel();
        VehPolicy vehPolicy = new VehPolicy();
        vehPolicy.setPolicyNbr("123");
        vehPolicy.setPremium(500D);
        List<Person> personList = new ArrayList<>();
        Person namedInsured = new Person("Jon", "Doe", "NI");
        Person spouse = new Person("Spouse", "Doe", "SP");
        personList.add(namedInsured);
        personList.add(spouse);

        model.setPersons(personList);
        model.setVehPolicy(vehPolicy);

        return model;

    }

    @Test
    void mapResponseModelToApiResponse() {

        apiResponse =  mapperBase.mapResponseModelToApiResponse(mockModel);
        assertNotNull(apiResponse);
        assertNotNull(apiResponse.getPolicyNbr());

    }
}