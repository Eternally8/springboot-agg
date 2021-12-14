package com.robben.utils.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Description： TODO
 * Author: robben
 * Date: 2020/8/14 11:05
 */

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(source = "name", target = "carName")
    CarVo carDtoToCarVo(CarDto carDto);

}
