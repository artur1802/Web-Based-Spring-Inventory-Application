package com.example.demo.controllers;

import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping("/buy")
    public String buyProduct(@RequestParam Long productId) {
        boolean success = productService.buyProduct(productId);
        if (success) {

            return "successPage";
        } else {

            return "errorProduct";
        }

    }



}
