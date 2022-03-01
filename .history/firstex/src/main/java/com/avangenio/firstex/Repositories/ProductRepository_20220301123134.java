package com.avangenio.firstex.Repositories;

import java.util.Optional;

import com.avangenio.firstex.Entities.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
    Optional<Product> findByUsername(String username);
    Optional<Product> findByUsername(String username);
    Optional<Product> findByUsername(String username);
    Optional<Product> findByUsername(String username);

}

