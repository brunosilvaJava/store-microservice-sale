package com.sales.sale.domain.converters;

import java.util.List;

import com.sales.sale.domain.model.SaleEntity;
import com.sales.sale.dto.SaleDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SaleMapper {

    SaleMapper INSTANCE = Mappers.getMapper(SaleMapper.class);

    @Mapping(source = "itens", target = "products")
    SaleDto entityToDto(SaleEntity saleEntity);

    List<SaleDto> entitysToDtos(List<SaleEntity> saleEntities);

    @Mapping(source = "products", target = "itens")
    SaleEntity dtoToEntity(SaleDto saleDto);

    List<SaleEntity> dtosToEntities(List<SaleDto> saleDtos);

}
