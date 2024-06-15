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

@Mapper(
        uses = { JsonNullableMapper.class },
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class CarMapper {

    @Mapping(target = "id", ignore = true)
    public abstract CarDTO mapToDTO(Car car);

    @Mapping(target = "id", ignore = true)
    public abstract Car mapToEntity(CarCreateDTO dto);

    @Mapping(target = "id", ignore = true)
    public abstract void updateCarFromDTO(CarUpdateDTO dto, @MappingTarget Car car);

}
