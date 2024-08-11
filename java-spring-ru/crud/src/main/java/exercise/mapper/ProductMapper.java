package exercise.mapper;

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

// BEGIN
@Mapper(
        uses = { ReferenceMapper.class },
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProductMapper {

    @Mapping(target = "category", source = "categoryId")
    Product map(ProductCreateDTO dto);

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "category.name", target = "categoryName")
    ProductDTO map(Product model);

    @Mapping(target = "category", source = "categoryId")
    void update(ProductUpdateDTO dto, @MappingTarget Product model);

    // Добавьте методы для преобразования JsonNullable
    default String map(JsonNullable<String> value) {
        return value.orElse(null);
    }

    default int map(JsonNullable<Integer> value) {
        return value.orElse(0); // Можно заменить 0 на любое значение по умолчанию
    }
}
// END
