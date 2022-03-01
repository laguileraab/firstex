package com.avangenio.firstex.Controller;

import java.util.List;

import com.avangenio.firstex.Entities.Product;
import com.avangenio.firstex.Services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class RestAPIProduct {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/add/product", method = RequestMethod.POST)
    public Boolean addProduct(Product product) {
        productService.saveOrUpdate(product);
        return true;
    }

    @GetMapping(value = "/list/products")
    public List<Product> listProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/list/products/{filter}", method = RequestMethod.POST)
    public List<Product> listProducts(@PathVariable String filter) {
        switch(filter){
            case "section":
            break;
            case "lot":
            break;
            case "fragile":
            break;
            case "color":
            break;
            case "section":
            break;
            case "type":
            break;
            default:
            
            break;
        }
        return productService.getProductByFilterColor(filter);
    }
}
