package com.avangenio.firstex.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import com.avangenio.firstex.Entities.EnvelopType;
import com.avangenio.firstex.Entities.Product;
import com.avangenio.firstex.Repositories.ProductRepository;
import com.avangenio.firstex.Repositories.SectionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SectionRepository sectionRepository;

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<Product>();
        productRepository.findAll().forEach(product -> products.add(product));
        return products;
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).get();
    }

    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }

    public void delete(int id) {
        productRepository.deleteById(id);
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }

    public List<Product> getProductByFilterColor(String color) {
        return productRepository.findByColor(color);
    }

    public List<Product> getProductByFilterLot(String lot) {
        return productRepository.findByLot(lot);
    }

    public List<Product> getProductByFilterFragile(Boolean fragile) {
        return productRepository.findByFragile(fragile);
    }

    public List<Product> getProductByFilterPrice(String filter) {
        List<Product> products = new ArrayList<Product>();

        if (filter.contains("-")) {
            String[] range = filter.split("-");
            productRepository.findAll().forEach((product) -> {
                if (product.getPrice() => Double.parseDouble(range[0])
                        && product.getPrice() <= Double.parseDouble(range[1])) {
                    products.add(product);
                }
            });
        } else {
            Double price = Double.parseDouble(filter);
            productRepository.findAll().forEach((product) -> {
                if (product.getPrice() == price) {
                    products.add(product);
                }
            });
        }
        return products;
    }

    public List<Product> getProductByFilterEnvelop(EnvelopType envelop) {
        return productRepository.findByEnvelop(envelop);
    }

    public List<Product> getProductByFilterSection(int filter) throws NoSuchElementException {
        List<Product> products = new ArrayList<Product>();
        if (sectionRepository.findById(filter).isEmpty()) {
            throw new NoSuchElementException("Section not found!");
        }
        sectionRepository.findById(filter).get().getProducts().forEach((product) -> {
            products.add(product);
        });
        return products;
    }

    public Boolean saveOrUpdateAll(Set<Product> products) {
        productRepository.saveAll(products);
        return true;
    }

    public List<Product> getProductByFilterQuantity(int quantity) {
        return productRepository.findByQuantity(quantity);
    }
}
