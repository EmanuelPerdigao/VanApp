package org.vanApp.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vanApp.entity.Product;
import org.vanApp.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    //#############################  GET ALL PRODUCTS   ####################################
    @RequestMapping(method = RequestMethod.GET, path = {"/list"})
    public ResponseEntity<List<Product>> listProducts() {

        List<Product> products = productService.listAllProducts();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }



    //#############################  GET A PRODUCT BY ID  ####################################
    @RequestMapping(method = RequestMethod.GET, path = {"/{id}"})
    public ResponseEntity<Optional<Product>> findProducts(@PathVariable Long id){

        if (!productService.getById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Optional<Product> product = productService.getById(id);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }



    //#############################  SAVE A PRODUCT  ########################################
    @RequestMapping(method = RequestMethod.POST, path = {"/save"})
    public ResponseEntity<String> saveProduct(@RequestBody Product product) {

        productService.saveProduct(product);

        return new ResponseEntity<>("Product saved successfully", HttpStatus.OK);
    }



    //#############################  UPDATE A PRODUCT  ########################################
    @RequestMapping(method = RequestMethod.PUT, path = {"/update"})
    public ResponseEntity<String> updateProduct(@RequestBody Product product) {

        if (!productService.getById(product.getId()).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        productService.updateProduct(product);

        return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
    }



    //#############################  DELETE A PRODUCT  ########################################
    @RequestMapping(method = RequestMethod.DELETE, path = {"/delete/{id}"})
    public ResponseEntity<String> deleteProduct(@PathVariable long id) {

        if (!productService.getById(id).isPresent()) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
        productService.deleteProduct(id);

        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }





}
