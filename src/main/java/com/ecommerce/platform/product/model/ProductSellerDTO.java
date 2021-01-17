package com.ecommerce.platform.product.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductSellerDTO {
    private String id;
    private String name;

}
