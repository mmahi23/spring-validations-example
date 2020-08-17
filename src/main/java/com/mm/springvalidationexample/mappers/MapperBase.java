package com.mm.springvalidationexample.mappers;

import com.mm.springvalidationexample.models.ApiResponse;
import com.mm.springvalidationexample.models.Person;
import com.mm.springvalidationexample.models.PersonView;
import com.mm.springvalidationexample.models.ResponseModel;
import org.mapstruct.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper(componentModel = "spring",
        uses = MapperHelper.class,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapperBase {

    @Mappings({
            @Mapping(source = "input.vehPolicy.policyNbr", target = "policyNbr"),
            @Mapping(target = "namedInsured", qualifiedByName = {"MapperHelper", "mapNamedInsured"},
                    source = "persons"),
            @Mapping(target = "spouse", qualifiedByName = {"MapperHelper", "mapSpouse"},
                    source = "persons")})
    ApiResponse mapResponseModelToApiResponse(ResponseModel input);


}
