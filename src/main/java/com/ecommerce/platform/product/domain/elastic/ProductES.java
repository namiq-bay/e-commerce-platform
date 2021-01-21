package com.ecommerce.platform.product.domain.elastic;

import com.ecommerce.platform.product.domain.MoneyTypes;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;
import java.util.HashMap;


@Getter
@Setter
@Builder
@Document(indexName = "product")
@EqualsAndHashCode(of = "id")
public class ProductES {

    private String id;
    private String name;
    private String code;
    private String description;
    private CompanyES seller;
    private String features;
    private CategoryES category;
    private HashMap<MoneyTypes, BigDecimal> price;
    private Boolean active;

}
