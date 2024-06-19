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
import org.openapitools.jackson.nullable.JsonNullable;

// BEGIN
@Mapper(
        uses = { ReferenceMapper.class, CategoryMapper.class },
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProductMapper {

    @Mapping(target = "category", source = "categoryId")
    Product map(ProductCreateDTO dto);

    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "categoryName", source = "category.name")
    ProductDTO map(Product product);

    @Mapping(target = "category", source = "categoryId")
    void update(ProductUpdateDTO dto, @MappingTarget Product product);

    default String map(JsonNullable<String> nullableString) {
        return nullableString.orElse(null);
    }

    default Integer map(JsonNullable<Integer> nullableInteger) {
        return nullableInteger.orElse(null);
    }

    default Long map(JsonNullable<Long> nullableLong) {
        return nullableLong.orElse(null);
    }
}
// END
