package com.avangenio.firstex.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import com.avangenio.firstex.Entities.EnvelopType;
import com.avangenio.firstex.Entities.Product;
import com.avangenio.firstex.Entities.Section;
import com.avangenio.firstex.Payload.Response.MessageResponse;
import com.avangenio.firstex.Services.ProductService;
import com.avangenio.firstex.Services.SectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.util.EnumUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class RestAPIProduct {

    @Autowired
    ProductService productService;

    @Autowired
    SectionService sectionService;

    @PostMapping(value = "/add/products/{id}")
    public ResponseEntity<?> addProducts(@RequestBody Set<Product> products, @PathVariable int id) {
        try {
            Section section = sectionService.getSectionById(id);
            products.forEach((product) -> {
                product.setSection(section);
                product.setColor(product.getColor().toLowerCase());
                product.setLot(product.getLot().toUpperCase());
                Arrays.stream(EnvelopType.values()).anyMatch(e - >e.equals(product.getEnvelop()));
                    
                return ResponseEntity.badRequest().body(new MessageResponse("Type of envelop not found!"));
                
            });
            productService.saveOrUpdateAll(products);
            return ResponseEntity.ok(new MessageResponse("Products added successfully!"));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(new MessageResponse("Section not found!"));
        }
    }

    @PostMapping(value = "/add/product/{id}")
    public ResponseEntity<?> addProduct(@RequestBody Product product, @PathVariable int id) {
        try {
            product.setSection(sectionService.getSectionById(id));
            product.setColor(product.getColor().toLowerCase());
            product.setLot(product.getLot().toUpperCase());
            productService.saveOrUpdate(product);
            return ResponseEntity.ok(new MessageResponse("Product added successfully!"));
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.badRequest().body(new MessageResponse("Section not found!"));
        }
    }

    @GetMapping(value = "/rem/product/{id}")
    public ResponseEntity<?> delProduct(@PathVariable int id) {
        try {
            productService.delete(id);
            return ResponseEntity.ok(new MessageResponse("Product deleted successfully!"));

        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.ok(new MessageResponse("Product not found!"));
        }
    }

    @GetMapping(value = "/list/products")
    public List<Product> listProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(value = "/list/products/{filterType}/{filter}")
    public List<Product> listProducts(@PathVariable String filterType, @PathVariable String filter) {
        switch (filterType) {
            case "section":
                // return productService.getProductByFilterSection(Integer.parseInt(filter));
            case "lot":
                return productService.getProductByFilterLot(filter);
            case "fragile":
                return productService.getProductByFilterFragile(Boolean.getBoolean(filter.toUpperCase()));
            case "color":
                return productService.getProductByFilterColor(filter.toLowerCase());
            case "price":
                // return productService.getProductByFilterPrice(filter);
            case "envelop":
                return productService.getProductByFilterEnvelop(
                        EnvelopType.valueOf(filter.substring(0, 1).toUpperCase() + filter.substring(1).toLowerCase()));
            default:
                return productService.getAllProducts();
        }
    }
}
