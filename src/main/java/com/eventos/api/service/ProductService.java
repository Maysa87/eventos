package com.eventos.api.service;

import com.eventos.api.dto.ProductDTO;
import com.eventos.api.entity.Product;
import com.eventos.api.mapper.ProductMapper;
import com.eventos.api.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper, ProductRepository repository) {
        this.productMapper = productMapper;
        this.repository = repository;
    }

    @Transactional
    public List<ProductDTO> getProducts(){
        return productMapper.entitiesToDtos(repository.findAllByActiveTrue());
    }
    @Transactional
    public ProductDTO save (ProductDTO productDto){
        Product newProduct =  productMapper.dtoToEntity(productDto);
        newProduct.setActive(true);
        return productMapper.entityToDto(repository.save(newProduct));
    }
    @Transactional
    public ProductDTO update (ProductDTO productDto){
        Product product = repository.findById(productDto.getId()).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDto.getName());
        product.setPriceInCents(productDto.getPriceInCents());
        return productMapper.entityToDto(repository.save(product));
    }
    @Transactional
    public void delete (String id){
        Product product = repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setActive(false);
    }
}
