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
        uses = { JsonNullableMapper.class, ReferenceMapper.class },
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProductMapper {

    @Mapping(target = "category.id", source = "categoryId")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "price", source = "price")
    Product map(ProductCreateDTO createDTO);

    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "categoryName", source = "category.name")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    ProductDTO map(Product product);

    @Mapping(target = "category.id", source = "categoryId")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "price", source = "price")
    void update(ProductUpdateDTO updateDTO, @MappingTarget Product product);
}
// END
