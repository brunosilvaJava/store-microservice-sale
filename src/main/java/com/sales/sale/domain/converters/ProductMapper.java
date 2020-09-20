package com.sales.sale.domain.converters;

import java.util.List;

import com.sales.sale.domain.model.ItemSaleEntity;
import com.sales.sale.dto.ProductDto;
import com.sales.sale.infrastructure.dto.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto entityToDto(ItemSaleEntity itemSaleEntity);

    List<ProductDto> entitiesToDtos(List<ItemSaleEntity> itemSaleEntities);

    ItemSaleEntity dtoToEntity(ProductDto productDto);

    List<ItemSaleEntity> dtosToEntities(List<ProductDto> productDtos);

    ProductDto responseToDto(ProductResponse productResponse);

    List<ProductDto> responsesToDtos(List<ProductResponse> productResponses);

    ProductResponse dtoToResponse(ProductDto productDto);

    List<ProductResponse> dtosToResponses(List<ProductDto> productDtos);



}
