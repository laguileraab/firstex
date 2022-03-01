package com.avangenio.firstex.Repositories;

import java.util.Optional;

import com.avangenio.firstex.Entities.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
    Optional<Product> findByColor(String color);
    Optional<Product> findByLot(String lot);
    Optional<Product> findByEnvelop(String envelop);
    Optional<Product> findByFragile(String username);
    Optional<Product> findByQuantity(int quantity);


}

