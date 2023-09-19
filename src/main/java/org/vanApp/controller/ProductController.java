package org.vanApp.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vanApp.entity.Product;
import org.vanApp.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/list"})
    public ResponseEntity<List<Product>> listProducts() {

        List<Product> products = productService.listAllProducts();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/save"})
    public ResponseEntity<String> saveProduct(@RequestBody Product product) {

        productService.saveOrUpdateProduct(product);

        return new ResponseEntity<>("Product saved successfully", HttpStatus.OK);
    }



}
