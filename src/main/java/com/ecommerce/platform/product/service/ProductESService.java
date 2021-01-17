package com.ecommerce.platform.product.service;


import com.ecommerce.platform.product.domain.Product;
import com.ecommerce.platform.product.domain.elastic.CategoryES;
import com.ecommerce.platform.product.domain.elastic.CompanyES;
import com.ecommerce.platform.product.domain.elastic.ProductES;
import com.ecommerce.platform.product.repository.elastic.ProductESRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductESService {

    private final ProductESRepository productESRepository;

    public Mono<ProductES> saveNewProduct(Product product) {
        return productESRepository.save(
                ProductES.builder()
                        .active(product.getActive())
                        .code(product.getCode())
                        .description(product.getDescription())
                        .features(product.getFeatures())
                        .id(product.getId())
                        .name(product.getName())
                        // TODO get company name and code
                        .seller(CompanyES.builder().id(product.getCompanyId()).name("Test").build())
                        // TODO get category name and code
                        .category(CategoryES.builder().id(product.getCategoryId()).name("Test").build())
                        .build());
    }

    public Flux<ProductES> findAll() {
        return productESRepository.findAll();
    }
}
