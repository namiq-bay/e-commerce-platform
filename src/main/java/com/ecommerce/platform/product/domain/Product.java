package com.ecommerce.platform.product.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;


@Setter
@Getter
@Builder
@Document(collation = "product")
@EqualsAndHashCode(of = "id")
public class Product {

    private String id;
    private String name;
    private String code;
    private String description;
    private String companyId;
    private String features;
    private String categoryId;
    private List<ProductImage> productImage;
    private Boolean active;
}

//
//    {
//            'id':
//            'image':'https://productimages.hepsiburada.net/s/32/500/10352568139826.jpg',
//            'name':'Awesome Product 1',
//            'description':'Product featured description',
//            'seller':'Awesome Company 1',
//            'features':'<li>Black Color</li> <li>Aluminum Case</li> <li>2 Years Warranty</li> <li>5 Inch (35x55mm)</li>',
//            'available':2,
//            'freeDelivery':true,
//            'deliveryIn':'In 3 days',
//            'price':120,
//            'category':
//            'money':'$'
//    }
