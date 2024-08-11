package exercise.controller;

import java.util.List;
import java.util.Optional;

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.mapper.ProductMapper;
import exercise.exception.ResourceNotFoundException;
import exercise.model.Category;
import exercise.repository.CategoryRepository;
import exercise.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository; // Добавляем CategoryRepository

    @Autowired
    private ProductMapper productMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> index() {
        var products = productRepository.findAll();
        return products.stream()
                .map(productMapper::map)
                .toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO show(@PathVariable Long id) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
        return productMapper.map(product);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO create(@Valid @RequestBody ProductCreateDTO productData) {
        var category = categoryRepository.findById(productData.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Category ID"));

        var product = productMapper.map(productData);
        product.setCategory(category); // Устанавливаем категорию

        productRepository.save(product);
        return productMapper.map(product);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO update(@RequestBody @Valid ProductUpdateDTO productData, @PathVariable Long id) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));

        var categoryId = productData.getCategoryId().orElse(null);
        var category = categoryId != null ? categoryRepository.findById(categoryId).orElse(null) : null;
        if (category == null && categoryId != null) {
            throw new IllegalArgumentException("Invalid Category ID");
        }

        productMapper.update(productData, product);
        if (category != null) {
            product.setCategory(category); // Устанавливаем категорию
        }

        productRepository.save(product);
        return productMapper.map(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Not Found: " + id);
        }
        productRepository.deleteById(id);
    }
}
