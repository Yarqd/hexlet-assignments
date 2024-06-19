package exercise.mapper;

import exercise.dto.CategoryDTO;
import exercise.dto.CategoryCreateDTO;
import exercise.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CategoryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "products", ignore = true)
    Category map(CategoryCreateDTO dto);

    CategoryDTO map(Category category);
}
