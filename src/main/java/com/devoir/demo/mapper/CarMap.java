package com.devoir.demo.mapper;

import com.devoir.demo.bo.CarBO;
import com.devoir.demo.dto.CarDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CarMap {

    CarDTO carBOToCarDTO(CarBO bo);
    CarBO  carDTOToCarBO(CarDTO dto);

}
