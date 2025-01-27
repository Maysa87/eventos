package com.eventos.api.controllers;

import com.eventos.api.entity.Product;
import com.eventos.api.dto.ProductDTO;
import com.eventos.api.service.ProductService;
    import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity <List<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }

    @PostMapping
    public ResponseEntity <Product> registerProduct(@RequestBody @Valid ProductDTO data){
        return ResponseEntity.ok(productService.save(data));
    }

    @PutMapping
    public ResponseEntity<Product>  updateProduct(@RequestBody @Valid ProductDTO data){
            return ResponseEntity.ok(productService.update(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
