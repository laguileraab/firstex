package com.avangenio.firstex.Repositories;

import java.util.Optional;
import java.util.Set;

import com.avangenio.firstex.Entities.EnvelopType;
import com.avangenio.firstex.Entities.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
    List<Product> findByColor(String color);
    List<Product> findByLot(String lot);
    List<Product> findByEnvelop(EnvelopType envelop);
    List<Product> findByFragile(Boolean fragile);
    List<Product> findByQuantity(int quantity);


}

