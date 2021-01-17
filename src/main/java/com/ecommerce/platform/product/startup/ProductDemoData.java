package com.ecommerce.platform.product.startup;

import com.ecommerce.platform.product.domain.MoneyTypes;
import com.ecommerce.platform.product.model.ProductSaveRequest;
import com.ecommerce.platform.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.UUID.randomUUID;

@Component
@RequiredArgsConstructor
public class ProductDemoData {
    private final ProductService productService;

    @EventListener(ApplicationReadyEvent.class)
    public void migrate() {

        Long countOfData = productService.count().block();
        if (countOfData.equals(0L)) {
            IntStream.range(0, 20).forEach(value -> {
                productService.save(
                        ProductSaveRequest.builder()
                                .sellerID(randomUUID().toString())
                                .id(randomUUID().toString())
                                .descripton("Product description " + value)
                                .money(MoneyTypes.USD)
                                .categoryID(randomUUID().toString())
                                .name("Product name " + value)
                                .features("<li>Black Color</li> <li>Aluminum Case</li> <li>2 Years Warranty</li> <li>5 Inch (35x55mm)</li>")
                                .price(BigDecimal.TEN)
                                .images(List.of("https://productimages.hepsiburada.net/s/32/500/10352568139826.jpg"))
                                .build());
            });
        }

    }
}
