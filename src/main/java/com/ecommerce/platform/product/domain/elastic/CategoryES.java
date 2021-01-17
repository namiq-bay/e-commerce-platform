package com.ecommerce.platform.product.domain.elastic;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryES {
    private String id;
    private String name;
    private String code;
}
