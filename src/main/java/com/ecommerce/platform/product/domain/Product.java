package com.ecommerce.platform.product.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;


@Setter
@Getter
@Builder
@Document(collection = "product")
@EqualsAndHashCode(of = "id")
public class Product {

    @Id
    private String id;
    private String name;
    private String code;
    private String description;
    private String companyId;
    private String features;
    private String categoryId;
    private List<ProductImage> productImage;
    private HashMap<MoneyTypes, BigDecimal> price;
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
