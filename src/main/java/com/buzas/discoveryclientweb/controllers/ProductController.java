package com.buzas.discoveryclientweb.controllers;

import com.buzas.discoveryclientweb.item.Product;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private List<Product> productList;
    private RestTemplate restTemplate;

    public ProductController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    private void Init() {
        productList = new ArrayList<>();
        productList.add(new Product(0L, "first", 15));
        productList.add(new Product(1L, "second", 72));
        productList.add(new Product(2L, "third", 133));
        productList.add(new Product(3L, "fourth", 40));
    }

    @GetMapping("/")
    public ModelAndView showProductString(Model model) {
        model.addAttribute("products", productList);
        return new ModelAndView("productsPage");
    }
}
