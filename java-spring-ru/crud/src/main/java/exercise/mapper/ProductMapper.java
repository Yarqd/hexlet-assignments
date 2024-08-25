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
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {

    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "price", target = "price")
    Product toProduct(ProductCreateDTO dto);

    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "price", target = "price")
    Product toProduct(ProductUpdateDTO dto, @MappingTarget Product model);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "updatedAt", target = "updatedAt")
    ProductDTO toProductDTO(Product product);

    // Methods to convert JsonNullable types to primitive types
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
