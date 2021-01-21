package com.ecommerce.platform.product.service;

import com.ecommerce.platform.product.domain.MoneyTypes;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductDeliveryService {

    public String getDeliveryInfo(String poductId){
        // TODO
        return "tomorrow";
    }

    public boolean checkFreeDelivery(String id, BigDecimal productPrice, MoneyTypes moneyTypes) {
        // TODO
        return true;
    }
}
