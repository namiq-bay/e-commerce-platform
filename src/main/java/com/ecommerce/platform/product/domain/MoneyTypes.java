package com.ecommerce.platform.product.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum MoneyTypes {
    USD("Dollar", "$"),
    EUR("Euro", "€"),
    TL("Lira", "₺"),
    RUB("Rubl", "₽");

    private String label;
    private String symbol;

    public String getSymbol() {
        return symbol;
    }
}
