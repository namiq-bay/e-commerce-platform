package com.ecommerce.platform.product.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


@Setter
@Getter
@Document(collation = "product_price")
@EqualsAndHashCode(of = "id")
public class ProductPrice {
    private String id;
    private String productId;
    private MoneyTypes moneyTypes;
    private String price;
}

