package org.vanApp.service;

import org.vanApp.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    /**
     * Gets the product with the given id
     *
     * @param id the product id
     * @return the product
     */
    Optional<Product> getById(Long id);

    /**
     * Saves a product
     *
     * @param product the product to save
     * @return the saved product
     */
    Product saveProduct(Product product);


    /**
     * Update a product
     *
     * @param product the product to update
     * @return the updated product
     */
    Product updateProduct(Product product);


    /**
     * Deletes a product
     *
     * @param id the product id
     */
    void deleteProduct(Long id);

    /**
     * Gets a list of the customers
     *
     * @return the customers list
     */
    List<Product> listAllProducts();
}
