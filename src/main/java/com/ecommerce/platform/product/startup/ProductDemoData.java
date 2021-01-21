package com.ecommerce.platform.product.startup;


import com.ecommerce.platform.product.domain.MoneyTypes;
import com.ecommerce.platform.product.model.category.CategoryDTO;
import com.ecommerce.platform.product.model.product.ProductSaveRequest;
import com.ecommerce.platform.product.repository.elastic.ProductESRepository;
import com.ecommerce.platform.product.repository.mongo.ProductRepository;
import com.ecommerce.platform.product.service.ProductService;
import com.ecommerce.platform.product.service.category.CategorySaveRequest;
import com.ecommerce.platform.product.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.UUID.randomUUID;

@Component
@RequiredArgsConstructor
public class ProductDemoData {
    private final ProductService productService;
    private final ProductESRepository productEsRepository;
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @EventListener(ApplicationReadyEvent.class)
    public void migrate() {
        Long countOfData = productService.count().block();

        if (!countOfData.equals(0L)) {

            productEsRepository.deleteAll().block() ;
            productRepository.deleteAll().block();

            CategoryDTO elektronik =
                    categoryService.save(CategorySaveRequest.builder().name("Elektronik").build());

            CategoryDTO telefon =
                    categoryService.save(CategorySaveRequest.builder().name("Cep Telefonu").build());

            IntStream.range(0, 20).forEach(item -> {
                HashMap<MoneyTypes, BigDecimal> price = new HashMap<>() {{
                    put(MoneyTypes.USD, BigDecimal.valueOf((item + 1) * 5));
                    put(MoneyTypes.EUR, BigDecimal.valueOf((item + 1) * 4));
                }};
                productService.save(
                        ProductSaveRequest.builder()
                                .sellerID(randomUUID().toString())
                                .id(randomUUID().toString())
                                .description("Product Description " + item)
                                .price(price)
                                .categoryID(telefon.getId())
                                .name("Product Name " + item)
                                .features("<li>Black Color</li> <li>Aluminum Case</li> <li>2 Years Warranty</li> <li>5 Inch (35x55mm)</li>")
                                .images(List.of("https://productimages.hepsiburada.net/s/32/500/10352568139826.jpg"))
                                .build());
            });
        }
    }
}