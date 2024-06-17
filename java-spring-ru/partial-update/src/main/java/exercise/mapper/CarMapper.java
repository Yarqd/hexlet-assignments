package exercise.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import exercise.dto.CarCreateDTO;
import exercise.dto.CarUpdateDTO;
import exercise.dto.CarDTO;
import exercise.model.Car;
import org.openapitools.jackson.nullable.JsonNullable;

// BEGIN
@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = JsonNullableMapper.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CarMapper {
    CarDTO toCarDTO(Car car);

    Car toCar(CarCreateDTO carCreateDTO);

    void updateCarFromDto(CarUpdateDTO carUpdateDTO, @MappingTarget Car car);
}
// END
