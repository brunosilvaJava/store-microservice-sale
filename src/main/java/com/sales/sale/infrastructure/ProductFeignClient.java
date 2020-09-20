package com.sales.sale.infrastructure;

import com.sales.sale.infrastructure.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductFeignClient {

    @GetMapping(value = "/{productCode}")
    ProductResponse findByProductCode (@PathVariable("productCode") Long productCode);

}
