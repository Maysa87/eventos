package com.eventos.api.service;

import com.eventos.api.dto.ProductDTO;
import com.eventos.api.entity.Product;
import com.eventos.api.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    @Transactional
    public List<Product> getProducts(){
        return repository.findAllByActiveTrue();
    }
    @Transactional
    public Product save (ProductDTO productDto){
        Product newProduct = new Product(productDto);
        return repository.save(newProduct);
    }
    @Transactional
    public Product update (ProductDTO productDto){
        Product product = repository.findById(productDto.id()).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDto.name());
        product.setPrice_in_cents(productDto.price_in_cents());
        return repository.save(product);
    }
    @Transactional
    public void delete (String id){
        Product product = repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setActive(false);
    }
}
