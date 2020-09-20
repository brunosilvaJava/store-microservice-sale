package com.sales.sale.service;

import java.util.Optional;

import com.sales.sale.infrastructure.ProductFeignClient;
import com.sales.sale.infrastructure.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductFeignClient productFeignClient;

    @Autowired
    public ProductService (ProductFeignClient productFeignClient){
        this.productFeignClient = productFeignClient;
    }

    public Optional<ProductResponse> findByProductCode(Long productCode){
        return Optional.of(productFeignClient.findByProductCode(productCode));
    }

}
