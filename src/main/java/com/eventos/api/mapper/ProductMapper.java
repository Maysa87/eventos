package com.eventos.api.mapper;

import com.eventos.api.dto.ProductDTO;
import com.eventos.api.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO entityToDto(Product product);
    Product dtoToEntity(ProductDTO product);

    List<ProductDTO> entitiesToDtos(List<Product> products);
}
