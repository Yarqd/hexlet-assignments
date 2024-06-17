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
import org.mapstruct.Context;
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

    void updateCarFromDto(CarUpdateDTO carUpdateDTO, @MappingTarget Car car, @Context JsonNullableMapper jsonNullableMapper);
}

package exercise.mapper;

import org.openapitools.jackson.nullable.JsonNullable;

public class JsonNullableMapper {

    public <T> T unwrap(JsonNullable<T> jsonNullable) {
        return jsonNullable == null ? null : jsonNullable.orElse(null);
    }

    public <T> boolean isPresent(JsonNullable<T> jsonNullable) {
        return jsonNullable != null && jsonNullable.isPresent();
    }
}
// END
