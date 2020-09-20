package com.sales.sale.service;

import java.math.BigDecimal;
import java.util.List;

import com.sales.sale.domain.converters.SaleMapper;
import com.sales.sale.domain.model.SaleEntity;
import com.sales.sale.domain.reposiroty.SaleRepository;
import com.sales.sale.dto.SaleDto;
import com.sales.sale.infrastructure.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleService {

    private SaleRepository saleRepository;
    private ClientService clientService;
    private ProductService productService;

    @Autowired
    public SaleService(SaleRepository saleRepository, ClientService clientService, ProductService productService){
        this.saleRepository = saleRepository;
        this.clientService = clientService;
        this.productService = productService;
    }

    @Transactional
    public void save(SaleDto saleDto){
        clientService.findByClientId(saleDto.getClientId()).orElseThrow(RuntimeException::new); // TODO EXCEPTION
        getValueAndDescription(saleDto);
        saleRepository.save(buildEntity(saleDto));
    }

    public void update (SaleDto saleDto){
        // TODO IMPLEMENTAR UPDATE
    }

    public void delete (Long saleId){
        saleRepository.deleteById(saleId);
    }

    public List<SaleDto> findAll(){
        return SaleMapper.INSTANCE.entitysToDtos(saleRepository.findAll());
    }

    public SaleDto findBySaleId(Long saleId){
        SaleEntity saleEntity = saleRepository.findById(saleId).orElseThrow(RuntimeException::new); // TODO EXCEPTION
        return SaleMapper.INSTANCE.entityToDto(saleEntity);
    }

    private SaleEntity buildEntity (final SaleDto saleDto) {
        SaleEntity saleEntity = SaleMapper.INSTANCE.dtoToEntity(saleDto);
        saleEntity.getItens().stream().forEach(itemSaleEntity -> itemSaleEntity.setSale(saleEntity));
        return saleEntity;
    }

    private void getValueAndDescription (final SaleDto saleDto) {
        saleDto.getProducts().stream().forEach(productDto -> {
            ProductResponse productResponse = productService.findByProductCode(productDto.getCode()).orElseThrow(RuntimeException::new);
            productDto.setDescription(productResponse.getDescription());
            productDto.setValue(productResponse.getValue());
        }); // TODO EXCEPTION
    }

    private BigDecimal getTotalValue (final SaleDto saleDto, final List<ProductResponse> productList) {
        return productList.stream().map(product ->
                product.getValue().multiply(getQuantity(saleDto, product)))
                .reduce(BigDecimal::add).orElseThrow(RuntimeException::new);
    }

    private BigDecimal getQuantity (final SaleDto saleDto, final ProductResponse product) {
        return saleDto.getProducts().stream().filter(
                productDto -> productDto.getCode().equals(product.getCode())).findFirst().get().getQuantity();
    }

}
