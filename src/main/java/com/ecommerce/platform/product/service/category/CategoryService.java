package com.ecommerce.platform.product.service.category;

import com.ecommerce.platform.product.domain.category.Category;
import com.ecommerce.platform.product.model.category.CategoryDTO;
import com.ecommerce.platform.product.repository.mongo.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Flux<CategoryDTO> getAll() {
        return categoryRepository.findAll().map(this::mapToDTO);
    }

    public Category getByID(String id) {
        return categoryRepository.findById(id).block();
    }

    public CategoryDTO save(CategorySaveRequest request) {
        Category category = Category.builder()
                .code("C" + request.getName().charAt(0))
                .name(request.getName())
                .build();

        return mapToDTO(categoryRepository.save(category).block());
    }

    private CategoryDTO mapToDTO(Category category) {
        if (category == null)
            return null;

        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
