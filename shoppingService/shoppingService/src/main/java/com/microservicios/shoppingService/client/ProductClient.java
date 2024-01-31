package com.microservicios.shoppingService.client;

import com.microservicios.shoppingService.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "productService")
@RequestMapping(value = "/products")
public interface ProductClient {

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id);
    @GetMapping(value = "/{id}/stock")
    public ResponseEntity<Product> updateStockProduct(@PathVariable  Long id ,@RequestParam(name = "quantity", required = true) Double quantity);

}
