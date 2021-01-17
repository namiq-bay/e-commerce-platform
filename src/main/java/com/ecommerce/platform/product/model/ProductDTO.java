package com.ecommerce.platform.product.model;

import com.ecommerce.platform.product.domain.MoneyTypes;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductDTO {
    private String id;
    private String image;
    private String name;
    private String description;
    private ProductSellerDTO seller;
    private String features;
    private int available;
    private boolean freeDelivery;
    private String deliveryIn;
    private BigDecimal price;
    private String categoryId;
    private MoneyTypes moneyTypes;


}
