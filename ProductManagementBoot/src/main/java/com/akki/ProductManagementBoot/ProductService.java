package com.akki.ProductManagementBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDB db;

    public void addProduct(Product product) {
        db.save(product);
    }

    public void displayAllProducts() {
        List<Product> products = db.findAll();
        products.forEach(System.out::println);
    }

    /*public void findByTxt(String text) {
        String txt = text.toLowerCase();

        List<Product> matchedProducts = db.findByTxt(txt);
        matchedProducts.forEach(System.out::println);
    }*/

}
