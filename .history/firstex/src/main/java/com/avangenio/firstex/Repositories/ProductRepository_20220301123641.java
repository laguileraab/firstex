package com.avangenio.firstex.Repositories;

import java.util.Optional;

import com.avangenio.firstex.Entities.EnvelopType;
import com.avangenio.firstex.Entities.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
    Optional<Product> findByColor(String color);
    Optional<Product> findByLot(String lot);
    Optional<Product> findByEnvelop(EnvelopType envelop);
    Optional<Product> findByFragile(Boolean fragile);
    Optional<Product> findByQuantity(int quantity);


}

