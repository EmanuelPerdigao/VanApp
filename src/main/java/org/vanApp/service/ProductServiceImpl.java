package org.vanApp.service;

import org.springframework.stereotype.Service;
import org.vanApp.entity.Product;
import org.vanApp.repository.ProductRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override


    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }



    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }
}
