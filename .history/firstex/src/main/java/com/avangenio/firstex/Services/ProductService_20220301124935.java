package com.avangenio.firstex.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    public Set<Product> getProductByFilterColor(String color) {
        return productRepository.findByColor(color);
    }

    public Set<Product> getProductByFilterLot(String lot) {
        /*List<Product> products = new ArrayList<Product>();
        productRepository.findAll().forEach((product) -> {
            if (product.getLot().equals(lot)) {
                products.add(product);
            }
        });
        return products;*/
        return productRepository.findByLot(lot);
    }

    public List<Product> getProductByFilterFragile(Boolean fragile) {
        List<Product> products = new ArrayList<Product>();
        productRepository.findAll().forEach((product) -> {
            if (product.getFragile() == fragile) {
                products.add(product);
            }
        });
        return products;
    }

    public List<Product> getProductByFilterPrice(String filter) {
        List<Product> products = new ArrayList<Product>();

        if (filter.contains("-")) {
            String[] range = filter.split("-");
            productRepository.findAll().forEach((product) -> {
                if (product.getPrice() <= Integer.parseInt(range[0])
                        && product.getPrice() >= Integer.parseInt(range[1])) {
                    products.add(product);
                }
            });
        } else {
            int range = Integer.parseInt(filter);
            productRepository.findAll().forEach((product) -> {
                if (product.getPrice() == range) {
                    products.add(product);
                }
            });
        }
        return products;
    }

    public List<Product> getProductByFilterType(String envelop) {
        List<Product> products = new ArrayList<Product>();
        productRepository.findAll().forEach((product) -> {
            if (product.getEnvelop().toString().equals(envelop)) {
                products.add(product);
            }
        });
        return products;
    }

    public List<Product> getProductByFilterSection(int filter) {
        /*List<Product> products = new ArrayList<Product>();
        sectionRepository.findById(filter).getProducts().forEach((section) -> {
            if (section.getType().toString().equals(filter)) {
                products.add(product);
            }
        });
        return products;*/
        return null;
    }

    public Boolean saveOrUpdateAll(Set<Product> products) {
        productRepository.saveAll(products);
        return true;
    }
}
