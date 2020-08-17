package com.mm.springvalidationexample.mappers;

import com.mm.springvalidationexample.models.Person;
import com.mm.springvalidationexample.models.PersonView;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
@Named("MapperHelper")
public class MapperHelper {

    @Named("mapNamedInsured")
    public PersonView mapNamedInsured(List<Person> personList) {

        if (personList != null) {
            PersonView namedInsured = new PersonView();
            Optional<Person> named = personList.stream().filter(pv -> "NI".equals(pv.getTypeCd())).findFirst();

            named.ifPresent(n -> namedInsured.setFirstName(n.getFirstName()));
            named.ifPresent(n -> namedInsured.setLastName(n.getLastName()));

            return namedInsured;

        }

        return null;
    }

    @Named("mapSpouse")
    public PersonView mapSpouse(List<Person> personList) {

        if (personList != null) {
            PersonView namedInsured = new PersonView();
            Optional<Person> named = personList.stream().filter(pv -> "SP".equals(pv.getTypeCd())).findFirst();

            named.ifPresent(n -> namedInsured.setFirstName(n.getFirstName()));
            named.ifPresent(n -> namedInsured.setLastName(n.getLastName()));

            return namedInsured;

        }

        return null;
    }
}
