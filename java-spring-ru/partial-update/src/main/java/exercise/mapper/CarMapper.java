package exercise.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.openapitools.jackson.nullable.JsonNullable;

import exercise.dto.CarCreateDTO;
import exercise.dto.CarUpdateDTO;
import exercise.dto.CarDTO;
import exercise.model.Car;

// BEGIN
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CarMapper {
    CarDTO toCarDTO(Car car);
    Car toCar(CarCreateDTO carCreateDTO);

    default void updateCarFromDto(CarUpdateDTO dto, @MappingTarget Car car) {
        if (dto.getModel() != null && dto.getModel().isPresent()) {
            car.setModel(dto.getModel().get());
        }
        if (dto.getManufacturer() != null && dto.getManufacturer().isPresent()) {
            car.setManufacturer(dto.getManufacturer().get());
        }
        if (dto.getEnginePower() != null && dto.getEnginePower().isPresent()) {
            car.setEnginePower(dto.getEnginePower().get());
        }
    }
}
// END
