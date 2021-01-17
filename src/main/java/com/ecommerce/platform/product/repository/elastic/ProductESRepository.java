package com.ecommerce.platform.product.repository.elastic;

import com.ecommerce.platform.product.domain.elastic.ProductES;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;

public interface ProductESRepository extends ReactiveElasticsearchRepository<ProductES, String> {
}
