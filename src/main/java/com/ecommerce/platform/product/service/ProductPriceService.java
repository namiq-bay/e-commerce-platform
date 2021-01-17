package com.ecommerce.platform.product.service;

import com.ecommerce.platform.product.domain.MoneyTypes;
import com.ecommerce.platform.product.repository.mongo.ProductPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductPriceService {

    private final ProductPriceRepository productPriceRepository;

    public BigDecimal getByMoneyType(String id, MoneyTypes moneyType) {
        return BigDecimal.TEN;
    }
}
