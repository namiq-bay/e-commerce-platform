package com.ecommerce.platform.product.service;


import com.ecommerce.platform.product.domain.Product;
import com.ecommerce.platform.product.domain.category.Category;
import com.ecommerce.platform.product.domain.elastic.CategoryES;
import com.ecommerce.platform.product.domain.elastic.CompanyES;
import com.ecommerce.platform.product.domain.elastic.ProductES;
import com.ecommerce.platform.product.repository.elastic.ProductESRepository;
import com.ecommerce.platform.product.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductESService {

    private final ProductESRepository productESRepository;
    private final CategoryService categoryService;

    public Mono<ProductES> saveNewProduct(Product product) {
        return productESRepository.save(
                ProductES.builder()
                        .active(product.getActive())
                        .code(product.getCode())
                        .description(product.getDescription())
                        .features(product.getFeatures())
                        .id(product.getId())
                        .price(product.getPrice())
                        .name(product.getName())
                        // TODO get company name and code
                        .seller(CompanyES.builder().id(product.getCompanyId()).name("Test").build())
                        // TODO get category name and code
                        .category(getProductCategory(product.getCategoryId()))
                        .build());
    }

    private CategoryES getProductCategory(String categoryId) {
        Category category = categoryService.getByID(categoryId);

        return CategoryES.builder()
                .id(category.getId())
                .name(category.getName())
                .code(category.getCode())
                .build();
    }

    public Flux<ProductES> findAll() {
        return productESRepository.findAll();
    }
}
