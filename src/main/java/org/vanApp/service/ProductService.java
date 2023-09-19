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
    Optional<Product> get(Long id);

    /**
     * Saves a customer
     *
     * @param product the product to save
     * @return the saved product
     */
    Product saveOrUpdateProduct(Product product);

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
