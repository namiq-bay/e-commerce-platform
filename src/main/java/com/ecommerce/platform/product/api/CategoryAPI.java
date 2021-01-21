package com.ecommerce.platform.product.api;

import com.ecommerce.platform.product.model.category.CategoryDTO;
import com.ecommerce.platform.product.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
@CrossOrigin("*")
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryAPI {

    private final CategoryService categoryService;

    @GetMapping
    public Flux<CategoryDTO> getAll() {
        return categoryService.getAll();
    }
}
