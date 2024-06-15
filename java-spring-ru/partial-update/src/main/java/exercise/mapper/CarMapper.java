package exercise.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import exercise.dto.CarCreateDTO;
import exercise.dto.CarUpdateDTO;
import exercise.dto.CarDTO;
import exercise.model.Car;
import org.mapstruct.MappingTarget;

//BEGIN
@Mapper(
        uses = { JsonNullableMapper.class },
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class CarMapper {

    public abstract void update(CarUpdateDTO dto, @MappingTarget Car car);

    @Mapping(target = "id", ignore = true)
    public abstract CarDTO mapToDTO(Car car);

    @Mapping(target = "id", ignore = true)
    public abstract Car mapToEntity(CarCreateDTO dto);

    public CarDTO mapToDTO(Car car) {
        if (car == null) {
            return null;
        }
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setModel(car.getModel());
        carDTO.setManufacturer(car.getManufacturer());
        carDTO.setEnginePower(car.getEnginePower());
        return carDTO;
    }

    public Car mapToEntity(CarCreateDTO dto) {
        if (dto == null) {
            return null;
        }
        Car car = new Car();
        car.setModel(dto.getModel());
        car.setManufacturer(dto.getManufacturer());
        car.setEnginePower(dto.getEnginePower());
        return car;
    }
}
// END
