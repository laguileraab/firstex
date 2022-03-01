package com.avangenio.firstex.Services;

import java.util.ArrayList;
import java.util.List;

import com.avangenio.firstex.Entities.Product;
import com.avangenio.firstex.Repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<Product>();
        productRepository.findAll().forEach(product -> products.add(product));
        return products;
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    public void saveOrUpdate(Product product) {
        productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }

    public List<Product> getProductByFilterColor(String filter) {
        List<Product> products = new ArrayList<Product>();
        productRepository.findAll().forEach((product) -> {
            if (product.getColor().equals(filter)) {
                products.add(product);
            }
        });
        return products;
    }

    public List<Product> getProductByFilterSection(String filter) {
        List<Product> products = new ArrayList<Product>();
        productRepository.findAll().forEach((product) -> {
            if (product.getColor().equals(filter)) {
                products.add(product);
            }
        });
        return products;
    }

    public List<Product> getProductByFilterLot(String filter) {
        List<Product> products = new ArrayList<Product>();
        productRepository.findAll().forEach((product) -> {
            if (String.valueOf(product.getLot()).equals(filter)) {
                products.add(product);
            }
        });
        return products;
    }

    public List<Product> getProductByFilterFragile(String filter) {
        List<Product> products = new ArrayList<Product>();
        productRepository.findAll().forEach((product) -> {
            if (Boolean.getBoolean(product.getFragile()).toString().equals(filter)) {
                products.add(product);
            }
        });
        return products;
    }

    public List<Product> getProductByFilterPrice(String filter) {
        List<Product> products = new ArrayList<Product>();
        productRepository.findAll().forEach((product) -> {
            if (product.getColor().equals(filter)) {
                products.add(product);
            }
        });
        return products;
    }

    public List<Product> getProductByFilterType(String filter) {
        List<Product> products = new ArrayList<Product>();
        productRepository.findAll().forEach((product) -> {
            if (product.getColor().equals(filter)) {
                products.add(product);
            }
        });
        return products;
    }
}
