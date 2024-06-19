package exercise.controller;

import java.util.List;

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.mapper.ProductMapper;
import exercise.model.Product;
import exercise.model.Category;
import exercise.repository.CategoryRepository;
import exercise.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exercise.exception.ResourceNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductMapper productMapper;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::map)
                .toList();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
        return productMapper.map(product);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO createProduct(@Valid @RequestBody ProductCreateDTO productCreateDTO) {
        // BEGIN
        // Проверка существования категории
        Category category = categoryRepository.findById(productCreateDTO.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id "
                        + productCreateDTO.getCategoryId()));

        // Маппинг DTO на сущность Product и установка категории
        Product product = productMapper.map(productCreateDTO);
        product.setCategory(category);

        // Сохранение продукта и возврат DTO
        Product savedProduct = productRepository.save(product);
        return productMapper.map(savedProduct);
        // END
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @Valid @RequestBody ProductUpdateDTO productUpdateDTO) {
        // BEGIN
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));

        // Обработка обновления категории, если она присутствует
        if (productUpdateDTO.getCategoryId().isPresent()) {
            Long categoryId = productUpdateDTO.getCategoryId().get();
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + categoryId));
            product.setCategory(category);
        }

        // Обработка обновления названия продукта
        if (productUpdateDTO.getTitle().isPresent()) {
            product.setTitle(productUpdateDTO.getTitle().get());
        }

        // Обработка обновления цены продукта
        if (productUpdateDTO.getPrice().isPresent()) {
            product.setPrice(productUpdateDTO.getPrice().get());
        }

        // Сохранение обновленного продукта и возврат DTO
        Product updatedProduct = productRepository.save(product);
        return productMapper.map(updatedProduct);
        // END
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id) {
        // BEGIN
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found with id " + id);
        }
        productRepository.deleteById(id);
        // END
    }
}
