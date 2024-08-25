package exercise.mapper;

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
//import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

// BEGIN
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {

    @Mapping(target = "category.id", source = "categoryId")
    Product map(ProductCreateDTO dto);

    @Mapping(target = "categoryId", source = "category.id")
    ProductDTO map(Product product);

    void update(ProductUpdateDTO dto, @MappingTarget Product model);

    default Long map(JsonNullable<Long> value) {
        return value.orElse(null);
    }

    default String map(JsonNullable<String> value) {
        return value.orElse(null);
    }

    default Integer map(JsonNullable<Integer> value) {
        return value.orElse(null);
    }
}
// END
