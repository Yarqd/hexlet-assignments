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

// BEGIN
@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = JsonNullableMapper.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CarMapper {
    CarDTO map(Car car);
    Car map(CarCreateDTO carCreateDTO);
    void update(CarUpdateDTO carUpdateDTO, @MappingTarget Car car); // Обновление модели Car на основе CarUpdateDTO
}
// END
