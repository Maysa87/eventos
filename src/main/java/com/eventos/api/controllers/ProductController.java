package com.eventos.api.controllers;

import com.eventos.api.dto.ProductDTO;
import com.eventos.api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity <List<ProductDTO>> getAllProducts(){;
        return ResponseEntity.ok(productService.getProducts());
    }

    @PostMapping
    public ResponseEntity<ProductDTO> registerProduct(@RequestBody @Valid ProductDTO data){
        return ResponseEntity.ok(productService.save(data));
    }

    @PutMapping
    public ResponseEntity<ProductDTO>  updateProduct(@RequestBody @Valid ProductDTO data){
                return ResponseEntity.ok(productService.update(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
