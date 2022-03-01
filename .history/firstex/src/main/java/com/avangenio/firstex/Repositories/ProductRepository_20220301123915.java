package com.avangenio.firstex.Repositories;

import java.util.Set;

import com.avangenio.firstex.Entities.EnvelopType;
import com.avangenio.firstex.Entities.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
    Set<Product> findByColor(String color);
    Set<Product> findByLot(String lot);
    Set<Product> findByEnvelop(EnvelopType envelop);
    Set<Product> findByFragile(Boolean fragile);
    Set<Product> findByQuantity(int quantity);


}

