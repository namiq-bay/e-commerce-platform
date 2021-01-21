package com.ecommerce.platform.product.api;

import com.ecommerce.platform.product.model.product.ProductDTO;
import com.ecommerce.platform.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductAPI {

    private final ProductService productService;

    @GetMapping
    public Flux<ProductDTO> getAllProducts() {


        Flux<ProductDTO> all = productService.getAll();

        all.doOnNext(productDTO -> System.out.println(productDTO.getCategoryId()));

        return all;
    }
}
