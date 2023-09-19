package org.vanApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vanApp.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
