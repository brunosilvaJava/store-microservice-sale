package com.sales.sale.infrastructure.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductResponse {

    private String code;
    private String description;
    private BigDecimal value;

}
