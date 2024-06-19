package exercise.mapper;

import exercise.dto.CategoryDTO;
import exercise.dto.CategoryCreateDTO;
import exercise.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO map(Category category);

    Category map(CategoryCreateDTO dto);
}
