package com.sales.sale.infrastructure;

import java.util.List;

import com.sales.sale.infrastructure.dto.ClientResponse;
import com.sales.sale.infrastructure.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "client-service")
public interface ClientFeignClient {

    @GetMapping
    List<ProductResponse> findAllClients();

    @GetMapping(value = "/{clientId}")
    ClientResponse findByClientId(@PathVariable("clientId") Long clientId);

}
