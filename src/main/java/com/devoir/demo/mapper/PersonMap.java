package com.devoir.demo.mapper;

import com.devoir.demo.bo.PersonBO;
import com.devoir.demo.dto.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;



@Mapper(componentModel = "spring")
public interface PersonMap {
    /*
    @Mappings({
            @Mapping(target = "identifiant", source = "personBO.id"),
    })

     */
    PersonDTO personBOToDTO(PersonBO personBO);

    /*
    @Mappings({
            @Mapping(target = "id", source = "personDTO.identifiant"),
    })
     */
    PersonBO personDTOToBO(PersonDTO personDTO);
}
