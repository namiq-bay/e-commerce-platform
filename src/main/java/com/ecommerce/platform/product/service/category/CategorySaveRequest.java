package com.ecommerce.platform.product.service.category;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategorySaveRequest {
    private String name;

}
