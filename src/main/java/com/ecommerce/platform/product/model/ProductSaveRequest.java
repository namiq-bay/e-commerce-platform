package com.ecommerce.platform.product.model;

import com.ecommerce.platform.product.domain.MoneyTypes;
import lombok.Builder;
import lombok.Data;

import java.lang.management.MemoryType;
import java.math.BigDecimal;
import java.util.List;


@Data
@Builder
public class ProductSaveRequest {

    private String id;
    private String name;
    private String descripton;
    private String features;
    private BigDecimal available;
    private BigDecimal price;
    private MoneyTypes money;
    private List<String> images;
    private String sellerID;
    private String categoryID;


//                    'image': 'https://productimages.hepsiburada.net/s/32/500/10352568139826.jpg',
//                    'name': 'Awesome Product 2',
//                    'description': 'Product featured description',
//                    'seller': 'Awesome Company 1',
//                    'features': '<li>Black Color</li> <li>Aluminum Case</li> <li>2 Years Warranty</li> <li>5 Inch (35x55mm)</li>',
//                    'available': 23,
//                    'freeDelivery': false,
//                    'deliveryIn': 'Tomorrow',
//                    'price':1550,
//                    'money':'TL'
}
