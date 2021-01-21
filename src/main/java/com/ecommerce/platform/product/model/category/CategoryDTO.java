package com.ecommerce.platform.product.model.category;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDTO {
    private String id;
    private String name;
}
