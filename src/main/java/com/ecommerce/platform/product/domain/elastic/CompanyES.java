package com.ecommerce.platform.product.domain.elastic;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyES {
    private String  id;
    private String name;
    private String code;
}
