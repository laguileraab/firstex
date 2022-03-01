package com.avangenio.firstex.Controller;

import java.util.List;
import java.util.Set;

import com.avangenio.firstex.Entities.Product;
import com.avangenio.firstex.Payload.Response.MessageResponse;
import com.avangenio.firstex.Services.ProductService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class RestAPIProduct {

    @Autowired
    ProductService productService;

    @PostMapping(value = "/add/products/{id}")
    public ResponseEntity<?> addProducts(@RequestBody Set<Product> products, @PathVariable int id){
        productService.saveOrUpdateAll(products);
        return ResponseEntity.ok(new MessageResponse("Products added successfully!"));
    }

    @PostMapping(value = "/add/product")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        productService.saveOrUpdate(product);
        return ResponseEntity.ok(new MessageResponse("Product added successfully!"));
    }

    @RequestMapping(value = "/list/products/{filterType}/{filter}", method = RequestMethod.POST)
    public List<Product> listProducts(@PathVariable String filterType, @PathVariable String filter) {
        switch(filterType){
            case "section":
            return productService.getProductByFilterSection(filter);
            case "lot":
            return productService.getProductByFilterLot(filter);
            case "fragile":
            return productService.getProductByFilterFragile(Boolean.getBoolean(filter));
            case "color":
            return productService.getProductByFilterColor(filter);
            case "price":
            return productService.getProductByFilterPrice(filter);
            case "type":
            return productService.getProductByFilterType(filter);
            default:
            return productService.getAllProducts();
        }
    }
}
