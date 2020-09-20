package com.sales.sale.service;

import java.util.List;
import java.util.Optional;

import com.sales.sale.infrastructure.ClientFeignClient;
import com.sales.sale.infrastructure.dto.ClientResponse;
import com.sales.sale.infrastructure.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private ClientFeignClient clientFeignClient;

    @Autowired
    public ClientService(ClientFeignClient clientFeignClient) {
        this.clientFeignClient = clientFeignClient;
    }

    public Optional<ClientResponse> findByClientId(Long clientId){
        return Optional.of(clientFeignClient.findByClientId(clientId));
    }

    public Optional<List<ProductResponse>> findAllProducts(){
        return Optional.of(clientFeignClient.findAllClients());
    }



}
